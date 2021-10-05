package org.iesfm.searchandwrite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    static Scanner scan = new Scanner(System.in);

    public static File askFilePath() {
        log.info("Escribe la ruta");
        String userFile = scan.nextLine();

        File filePath = new File(userFile);

        return filePath;
    }

    public static String askUserTextToRead() {
        log.info("Que texto buscas");
        return scan.nextLine();
    }

    public static int countWordInFile(String textToFind, File filePath) {
        int counter = 0;
        try(BufferedReader reader = new BufferedReader(
                new FileReader(filePath)
        )) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.contains(textToFind)) {
                    counter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    public static void writeResult(int numberToWrite, File destFile) {
        try (FileWriter writer = new FileWriter(destFile)) {
            writer.write("Resultado del texto es: " + numberToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeResult(countWordInFile(askUserTextToRead(), askFilePath()), askFilePath());
    }
}
