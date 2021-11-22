package org.iesfm.ficheros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileUtils {

    static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    static boolean containsUser(String user, File file) throws IOException {
        boolean found = false;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(user)) {
                    found = true;
                }
            }
        }
        return found;
    }

    public static void writeUser(String username, File file) throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(username + "\n");
        }
    }
}
