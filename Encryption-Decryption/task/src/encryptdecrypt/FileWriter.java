package encryptdecrypt;

import java.io.File;
import java.io.IOException;

public class FileWriter {
    static void writeFileData(String fileOut, String data) {

        File file = new File(fileOut);
        try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }

    }
}