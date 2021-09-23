package org.iesfm.ejercicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileToStringReader {

    private final static Logger log = LoggerFactory.getLogger(FileToStringReader.class);

    // 1. Listar ficheros en directorio /files
    // 2. Por cada fichero sacar el contenido
    // 3. Unir todos los ficheros e imprimir en pantalla

    public String readFile(File file) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            log.error("Error al leer el archivo " + file.getAbsolutePath(), e);
        }
        return builder.toString();
    }
}
