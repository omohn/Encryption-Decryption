package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    static String readFileData(String fileName) {
        File dataFile = new File(fileName);
        StringBuilder sb = new StringBuilder();

        try (Scanner fileScanner = new Scanner(dataFile)) {
            while (fileScanner.hasNext()) {
                sb.append(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file: " + fileName);
        }

        return sb.toString();
    }
}