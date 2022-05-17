package encryptdecrypt;

public class UnicodeCryptoMethod extends UnicodeMethod{

    public static final int UNICODE_START = 0x20;
    public static final int UNICODE_END = 0x7E;

    @Override
    public String encryptMessage(String message, int key) {
        int[] unicodeArray = getUnicodeArray(message);
        for (int i = 0; i < unicodeArray.length; i++) {
            unicodeArray[i] += key;
            if (unicodeArray[i] > UNICODE_END) {
                unicodeArray[i] += (UNICODE_START - UNICODE_END);
            }
        }

        return getStringFromInt(unicodeArray);
    }

    @Override
    public String decryptMessage(String message, int key) {
        int[] unicodeArray = getUnicodeArray(message);
        for (int i = 0; i < unicodeArray.length; i++) {
            unicodeArray[i] -= key;
            if (unicodeArray[i] < UNICODE_START) {
                unicodeArray[i] += (UNICODE_END - UNICODE_START);
            }
        }
        return getStringFromInt(unicodeArray);

    }


}
