package org.iesfm.ejercicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PrintLog {

    public static Logger log = LoggerFactory.getLogger(PrintLog.class);

    public static void main(String[] args) throws IOException {
        File logs = new File(args[0]);
        try(FileInputStream fis = new FileInputStream(logs)) {
            byte[] fileInBytes = fis.readAllBytes();
            String content = new String(fileInBytes, StandardCharsets.UTF_8);
            log.info(content);
        } catch (FileNotFoundException e) {
            log.error("No se ha encontrado el archivo " + args[0]);
        } catch (IOException e) {
            log.error("Error al leer el archivo", e);
        }
    }
}
