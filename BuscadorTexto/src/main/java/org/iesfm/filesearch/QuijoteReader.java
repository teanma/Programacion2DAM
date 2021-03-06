package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class QuijoteReader {

    private static Logger log = LoggerFactory.getLogger(QuijoteReader.class);

    public File quijoteFile(String path) {
        File file = null;
        try {
            file = new File(getClass().getResource(path).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file;
    }

    private String readElQuijote(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader =
                new BufferedReader(
                        new FileReader(file)
                )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            log.error("Error al leer el quijote" + file.getName(), e);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        QuijoteReader quijoteReader = new QuijoteReader();
        File quijoteFile = quijoteReader.quijoteFile("/el_quijote.txt");
        String quijoteStr = quijoteReader.readElQuijote(quijoteFile);
        log.info(quijoteStr);
    }
}
