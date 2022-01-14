package org.iesfm.socketdatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    private static Scanner scan = new Scanner(System.in);

    public static File askForFilePath() {
        log.info("Introduce la ruta del fichero");
        File file = new File(scan.nextLine());

        if (!file.exists()) {
            System.out.println("El fichero no existe");
        } else {
            return file;
        }
        return null;
    }

    public static File createFile() {
        log.info("Introduce la ruta del fichero");
        File file = new File(scan.nextLine());

        if (file.exists()) {
            System.out.println("El fichero ya existe");
            System.exit(0);
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
