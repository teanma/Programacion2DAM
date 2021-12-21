package org.iesfm.examen1accesodatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        String username = ScannerUtils.askForName();
        String path = ScannerUtils.askForFilePath();

        File directory= new File(path);
        FileUtils.list(directory);

        try{
            if (FileUtils.fileExists(directory, username)){
                //en caso de existir juntamos el path y el nombre de usuario
                File file = new File(path +"/"+ username);
                FileUtils.writeFile(file, "Ya existia"+ "\n");
            } else {
                //En caso de que no exista se pone en separado para crear el nuevo File
                File file = new File(path, username);
                file.createNewFile();
                FileUtils.writeFile(file, "Creado" + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
