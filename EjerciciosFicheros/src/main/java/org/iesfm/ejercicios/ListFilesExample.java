package org.iesfm.ejercicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ListFilesExample {

    public static Logger log = LoggerFactory.getLogger(ReadExample.class);

    public static void main(String[] args) {
        File folder = new File("/home/teodormardale/files");

        File[] files = folder.listFiles();
        for (File file : files) {
            log.info(file.getAbsolutePath());
        }
    }
}
