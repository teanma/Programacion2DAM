package org.iesfm.searchandwrite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FilePath {

    public static int searchWord(String text) {
        int contador = 0;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        "src/main/resources/el_quijote.txt"
                ))
        ) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(text)) {
                    contador++;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }
}
