package org.iesfm.buscanumeros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void writeToFile(File file, int number) {
        try (FileWriter writer = new FileWriter(file)) {
            for (int i  = 0; i < number; i++) {
                writer.write(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
