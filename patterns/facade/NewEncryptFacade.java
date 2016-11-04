public class NewEncryptFacade extends AbstractEncryptFacade {
    private EncryptFileReader reader;
    private NewCipherMachine cipher;
    private EncryptFileWriter writer;

    public NewEncryptFacade() {
        reader = new EncryptFileReader();
        cipher = new NewCipherMachine();
        writer = new EncryptFileWriter();
    }

    //调用其他对象的业务方法
    public void encrypt(String from, String to) {
        String plainText = reader.read(from);
        String encryptText = cipher.encrypt(plainText);
        writer.write(encryptText, to);
    }
}