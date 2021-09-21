package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

public class BufferedReaderExample {

    public static Logger log = LoggerFactory.getLogger(BufferedReaderExample.class);

    public static void main(String[] args) {

    }

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
