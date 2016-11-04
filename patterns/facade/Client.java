public class Client {
    public static void main(String[] args) {
        // EncryptFacade ef = new EncryptFacade();  
        // ef.encrypt("src.txt", "des.txt");
        AbstractEncryptFacade facade;
        // getBean()的返回类型为Object，需要进行强制类型转换
        facade = (AbstractEncryptFacade)XMLUtil.getBean();
        facade.encrypt("src.txt", "des.txt");
    }
}