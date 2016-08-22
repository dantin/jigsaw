public class Client {
    public static void main(String args[]) {
        LoggerFactory factory;
        Logger logger;
        // getBean()的返回类型为Object，需要进行强制类型转换
        factory = (LoggerFactory)XMLUtil.getBean();
        logger = factory.createLogger();
        logger.writeLog();
    }
}