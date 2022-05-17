package encryptdecrypt;

public class ShiftCryptoMethod extends UnicodeMethod{

    public static final int SMALL_A = 'a';
    public static final int SMALL_Z = 'z';
    public static final int CAP_A = 'A';
    public static final int CAP_Z = 'Z';

    @Override
    public String encryptMessage(String message, int key) {
        int[] unicodeArray = getUnicodeArray(message);
        for (int i = 0; i < unicodeArray.length; i++) {
            if (unicodeArray[i] >= CAP_A && unicodeArray[i] <= CAP_Z) {
                unicodeArray[i] += key;
                if (unicodeArray[i] > CAP_Z) {
                    unicodeArray[i] = unicodeArray[i] - CAP_Z + CAP_A - 1;

                }

            } else if (unicodeArray[i] >= SMALL_A && unicodeArray[i] <= SMALL_Z) {
                unicodeArray[i] += key;
                if (unicodeArray[i] > SMALL_Z) {
                    unicodeArray[i] = unicodeArray[i] - SMALL_Z + SMALL_A - 1;
                }

            }
        }

        return getStringFromInt(unicodeArray);
    }

    @Override
    public String decryptMessage(String message, int key) {
        int[] unicodeArray = getUnicodeArray(message);
        for (int i = 0; i < unicodeArray.length; i++) {
            if (unicodeArray[i] >= CAP_A && unicodeArray[i] <= CAP_Z) {
                unicodeArray[i] -= key;
                if (unicodeArray[i] < CAP_A) {
                    unicodeArray[i] = unicodeArray[i] + CAP_Z - CAP_A + 1;

                }

            } else if (unicodeArray[i] >= SMALL_A && unicodeArray[i] <= SMALL_Z) {
                unicodeArray[i] -= key;
                if (unicodeArray[i] < SMALL_A) {
                    unicodeArray[i] = unicodeArray[i] + SMALL_Z - SMALL_A + 1;
                }

            }
        }

        return getStringFromInt(unicodeArray);

    }
}
