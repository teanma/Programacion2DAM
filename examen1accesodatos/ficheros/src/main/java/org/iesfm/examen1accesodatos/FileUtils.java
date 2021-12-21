package org.iesfm.examen1accesodatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileUtils {
    private static final Logger log = LoggerFactory.getLogger(ScannerUtils.class);

    public static void list(File filePath) {
        File[] files = filePath.listFiles();
        for (File file : files) {
            log.info(file.getName());
        }
    }

    public static void writeFile(File file, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(content);
        }
    }

    public static boolean fileExists(File filePath, String fileName) {
        //filePath.getAbsolutePath obtiene la ruta + fileName, el nombre del fichero
        //'/something/' + 'name'
        String path = filePath.getAbsolutePath() + "/" + fileName;

        //devuelve nuevo fichero y con 'exists' comprueba si existe
        return new File(path).exists();
    }

    public static String readFile(File file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line=reader.readLine()) !=null){
                stringBuilder.append(line).append("\n");
            }
        } catch(IOException e ){
            log.info("Se ha producido un error leyendop el archivo" + file.getName() , e);

        }
        return stringBuilder.toString();
    }
}
