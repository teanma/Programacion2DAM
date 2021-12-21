package org.iesfm.examen1accesodatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scan = new Scanner(System.in);
    private static final Logger log = LoggerFactory.getLogger(ScannerUtils.class);

    public static String  askForName(){
        log.info("introduce el nombre de usuario: ");
        return scan.nextLine();
    }

    public static String askForFilePath (){
        log.info("Introduce la ruta del directorio: ");
        return scan.nextLine();
    }
}
