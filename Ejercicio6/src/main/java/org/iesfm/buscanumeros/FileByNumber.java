package org.iesfm.buscanumeros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileByNumber {
    
    private static Logger log = LoggerFactory.getLogger(FileByNumber.class);

    public static File createFile(int number) throws IOException {
        File file = new File(number + ".txt");
        file.createNewFile();
        return file;
    }
}
