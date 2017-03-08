/* BTrace Script Template */
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class PrintTimes {
	/* put your code here */
    @TLS
    private static long startTime = 0;

    @OnMethod(clazz = "/.+/", method = "/visitWeb/")
    public static void startMethod() {
        startTime = timeMillis();
    }

    @OnMethod(clazz = "/.+/", method = "/visitWeb/", location = @Location(Kind.RETURN))
    public static void endMethod() {
        print(strcat(strcat(name(probeClass()), "."), probeMethod()));
        print(" [");
        print(strcat("Time taken: ", str(timeMillis() - startTime)));
        println("]");
    }
}