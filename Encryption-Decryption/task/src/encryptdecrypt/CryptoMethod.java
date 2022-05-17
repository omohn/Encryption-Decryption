package encryptdecrypt;

public interface CryptoMethod {

    String encryptMessage(String message, int key);

    String decryptMessage(String message, int key);
}
