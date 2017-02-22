import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * javac -cp .:cglib-nodep-3.2.4.jar PermTestDemo.java
 * java -cp .:cglib-nodep-3.2.4.jar -XX:+PrintGCDetails -XX:MaxMetaspaceSize=5m PermTestDemo
 */
public class PermTestDemo {
    public static void main(String[] args) {
        CGlibBean cGlibBean = new CGlibBean();
        int i = 0;
        try {
            for (i = 0; i < 100000; i++) {
                CGlibBean newCGlibBean = getCGlibBean(cGlibBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("total create count: " + i);
        }
    }

    private static class CGlibBean {
        public CGlibBean() {

        }
    }

    private static CGlibBean getCGlibBean(final CGlibBean cGlibBean) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(cGlibBean.getClass().getClassLoader());
        enhancer.setSuperclass(cGlibBean.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return method.invoke(cGlibBean, objects);
            }
        });
        CGlibBean newCGlibBean = (CGlibBean) enhancer.create();
        return newCGlibBean;
    }
}