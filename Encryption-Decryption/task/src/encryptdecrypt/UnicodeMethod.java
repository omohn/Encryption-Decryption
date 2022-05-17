package encryptdecrypt;

public abstract class UnicodeMethod implements CryptoMethod{



    int[] getUnicodeArray(String message) {
        int[] uniCodes = new int[message.length()];

        for (int i = 0; i < uniCodes.length; i++) {
            uniCodes[i] = message.charAt(i);
        }

        return uniCodes;
    }

    String getStringFromInt(int[] array) {
        StringBuilder sb = new StringBuilder();
        char ch;

        for (int j : array) {
            ch = (char) j;
            sb.append(ch);
        }
        return sb.toString();
    }
}
