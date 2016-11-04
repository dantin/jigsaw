public class EncryptFacade extends AbstractEncryptFacade {
    private EncryptFileReader reader;
    private CipherMachine cipher;
    private EncryptFileWriter writer;

    public EncryptFacade() {
        reader = new EncryptFileReader();
        cipher = new CipherMachine();
        writer = new EncryptFileWriter();
    }

    //调用其他对象的业务方法
    public void encrypt(String from, String to) {
        String plainText = reader.read(from);
        String encryptText = cipher.encrypt(plainText);
        writer.write(encryptText, to);
    }
}