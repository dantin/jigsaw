/** 
 * java -server -Xms1024m -Xmx1024m -Xmn384m -XX:+UseParallelOldGC -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/david/Documents/code/cosmos/jigsaw/java/test/heap.bin GCTest
 */
public class GCTest {

    public static void main(String[] args) {
        final int _1mb = 1024 * 1024;
        byte[] value1 = new byte[_1mb * 100];
        byte[] value2 = new byte[_1mb * 100];
        byte[] value3 = new byte[_1mb * 100];
        new Thread() {
            public void run() {
                byte[] value4 = new byte[_1mb * 400];
            }
        } .start();
        byte[] value5 = new byte[_1mb * 200];
    }
}