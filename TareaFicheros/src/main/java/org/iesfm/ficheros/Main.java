package org.iesfm.ficheros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Main {

    static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String username = ScannerUtils.pideNombre();
        File file = null;
        try {
            file = ScannerUtils.pideRuta();

            if (FileUtils.containsUser(username, file)) {
                log.info("El usuario está registrado");
            } else {
                FileUtils.writeUser(username, file);
                log.info("Usuario registrado correctamente");
            }
        } catch (IOException e) {
            log.error("Error al registrar al usuario", e);
        }
    }
}
