package org.iesfm.ejercicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadExample {

    public static Logger log = LoggerFactory.getLogger(ReadExample.class);

    public static void main(String[] args) {
        try (BufferedReader reader =
                new BufferedReader(
                        new FileReader("/tmp/prueba.txt")
                )
        ) {
            String line;
            int numLines = 0;
            while ((line = reader.readLine()) != null) {
                numLines++;
            }
            log.info("Tiene " + numLines + " lineas");
        } catch (IOException e) {
            log.error("Excepción al leer el archivo", e);
        }
    }
}
