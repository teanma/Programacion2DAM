package org.iesfm.ejercicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Ejercicio5 {

    public static Logger log = LoggerFactory.getLogger(Ejercicio5.class);

    public static void moveAndRenameFile(String selectedPath, String destinationPath) {
        File file = new File(selectedPath);
        log.info("Renaming/moving " + selectedPath + " to new path: " + destinationPath);
        if (file.exists()) {
            file.renameTo(new File(destinationPath));
        } else {
            log.error("Couldn't mover or rename " + selectedPath);
        }
    }

    public static void deleteFolder(String selectedPath) {
        File folder = new File(selectedPath);
        log.info("Deleting " + selectedPath);
        if(folder.exists()) {
            folder.delete();
        } else {
            log.error("Folder doesn't exists");
        }
    }

    public static void main(String[] args) {
        moveAndRenameFile("/tmp/d1/f11.txt", "/tmp/d1/f12.txt");
        moveAndRenameFile("/tmp/d2/f21.txt", "tmp/d1/f21.txt");
        deleteFolder("/tmp/d2/");
    }
}
