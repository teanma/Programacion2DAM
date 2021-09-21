package org.iesfm.ejercicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Ej5 {

    private final static Logger log = LoggerFactory.getLogger(Ej5.class);

    private static void move(String origin, String destination) {
        log.info("Moviendo el archivo " + origin + " a " + destination);
        File file = new File(origin);
        file.renameTo(new File(destination));
    }

    private static void delete(String path) {
        log.info("Eliminando directorio " + path);
        File file = new File(path);
        file.delete();
    }

    public static void main(String[] args) {
        move("/tmp/d1/f11.txt", "/tmp/d1/f12.txt");
        move("/tmp/d2/f21.txt", "/tmp/d1/f21.txt");
        delete("/tmp/d2");
    }
}
