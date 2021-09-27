package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;

public class QuijoteWriter {

    private static Logger log = LoggerFactory.getLogger(QuijoteReader.class);

    public File classpath(String path) {
        File file = null;
        try {
            file = new File(getClass().getResource(path).toURI());
        } catch (URISyntaxException e) {
            log.error("", e);
        }
        return file;
    }

    public void writeContent(String content, File destination) {
        try(FileWriter writer = new FileWriter(destination)) {
            writer.write(content);
        } catch (IOException e) {
            log.error("", e);
        }
    }

    private String readFile(File file) {
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
        QuijoteWriter quijoteWriter = new QuijoteWriter();
        String elQuijoteStr = quijoteWriter.readFile(quijoteWriter.classpath("/el_quijote.txt"));
        quijoteWriter.writeContent(elQuijoteStr, new File("/tmp/el_quijote.txt"));
    }
}
