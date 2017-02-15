import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;

public class AioEchoServer {
    private static final int PORT = 8000;
    private AsynchronousServerSocketChannel server;

    public AioEchoServer() throws IOException {
        this.server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(PORT));
    }

    public void start() throws InterruptedException, ExecutionException, TimeoutException {
        System.out.printf("Server listen on %d\n", PORT);
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            final ByteBuffer buffer = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel channel, Object attachment) {
                System.out.println(Thread.currentThread().getName());
                Future<Integer> writeResult = null;
                try {
                    buffer.clear();
                    channel.read(buffer).get(100, TimeUnit.SECONDS);

                    buffer.flip();
                    writeResult = channel.write(buffer);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        server.accept(null, this);
                        writeResult.get();
                        channel.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failed(Throwable ex, Object attachment) {
                System.err.println(ex);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new AioEchoServer().start();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw e;
            }
        }
    }
}