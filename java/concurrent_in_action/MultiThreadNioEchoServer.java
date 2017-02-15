import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class MultiThreadNioEchoServer {
    private static Map<Socket, Long> timeStat = new HashMap<>(10240);
    private Selector selector;
    private ExecutorService pool = Executors.newCachedThreadPool();

    public void startServer() throws Exception {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        // InetSocketAddress isa = new InetSocketAddress(InetAddress.getLocalHost(), 8000);
        InetSocketAddress isa = new InetSocketAddress(8000);
        ssc.socket().bind(isa);

        SelectionKey acceptKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = readyKeys.iterator();
            long e = 0;
            while (it.hasNext()) {
                SelectionKey sk = it.next();
                it.remove();

                if (sk.isAcceptable()) {
                    doAccept(sk);
                } else if (sk.isValid() && sk.isReadable()) {
                    if (!timeStat.containsKey(((SocketChannel) sk.channel()).socket())) {
                        timeStat.put(((SocketChannel)sk.channel()).socket(), System.currentTimeMillis());
                    }
                    doRead(sk);
                } else if (sk.isValid() && sk.isWritable()) {
                    doWrite(sk);
                    e = System.currentTimeMillis();
                    long b = timeStat.remove(((SocketChannel)sk.channel()).socket());
                    System.out.printf("spend: %d ms\n", e - b);

                }
            }
        }
    }

    private void doAccept(SelectionKey sk) {
        ServerSocketChannel server = (ServerSocketChannel) sk.channel();
        SocketChannel clientChannel;
        try {
            clientChannel = server.accept();
            clientChannel.configureBlocking(false);

            SelectionKey clientKey = clientChannel.register(selector, SelectionKey.OP_READ);
            // Allocate an EchoClient instance and attach it to this selection key
            EchoClient echoClient = new EchoClient();
            clientKey.attach(echoClient);

            InetAddress clientAddress = clientChannel.socket().getInetAddress();
            System.out.printf("Accept connection from %s\n", clientAddress.getHostAddress());
        } catch (Exception e) {
            System.out.println("Failed to accept new client");
            e.printStackTrace();
        }
    }

    private void doRead(SelectionKey sk) {
        SocketChannel channel = (SocketChannel) sk.channel();
        ByteBuffer bb = ByteBuffer.allocate(8192);
        int len;

        try {
            len = channel.read(bb);
            if (len < 0) {
                disconnect(sk);
                return;
            }
        } catch (Exception e) {
            System.out.println("Failed to read from client");
            e.printStackTrace();
            disconnect(sk);
            return;
        }

        bb.flip();
        pool.execute(new HandleMsg(sk, bb));

    }

    private void doWrite(SelectionKey sk) {
        SocketChannel channel = (SocketChannel) sk.channel();
        EchoClient echoClient = (EchoClient)sk.attachment();
        LinkedList<ByteBuffer> outq = echoClient.getOutputQueue();

        ByteBuffer bb = outq.getLast();
        try {
            int len = channel.write(bb);
            if (len == -1) {
                disconnect(sk);
                return;
            }

            if (bb.remaining() == 0) {
                outq.removeLast();
            }
        } catch (Exception e) {
            System.out.println("Failed to write to client");
            e.printStackTrace();
            disconnect(sk);
        }

        if (outq.isEmpty()) {
            sk.interestOps(SelectionKey.OP_READ);
        }
    }

    private void disconnect(SelectionKey sk) {
        SocketChannel channel = (SocketChannel) sk.channel();
        try {
            channel.close();
        } catch (IOException e) {
            System.out.println("Failed to disconnect a client");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        MultiThreadNioEchoServer server = new MultiThreadNioEchoServer();
        server.startServer();
    }

    class HandleMsg implements Runnable {

        SelectionKey sk;
        ByteBuffer bb;

        public HandleMsg(SelectionKey sk, ByteBuffer bb) {
            this.sk = sk;
            this.bb = bb;
        }

        @Override
        public void run() {
            EchoClient echoClient = (EchoClient)sk.attachment();
            echoClient.enqueue(bb);
            sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            selector.wakeup();
        }
    }
}

class EchoClient {
    private LinkedList<ByteBuffer> outq;
    EchoClient() {
        outq = new LinkedList<ByteBuffer>();
    }

    public LinkedList<ByteBuffer> getOutputQueue() {
        return outq;
    }

    public void enqueue(ByteBuffer bb) {
        outq.add(bb);
    }
}