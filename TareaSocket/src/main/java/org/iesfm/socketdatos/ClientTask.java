package org.iesfm.socketdatos;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTask implements Runnable {

    private Scanner scan;
    private Socket socket;

    public ClientTask(Scanner scan, Socket socket) {
        this.scan = scan;
        this.socket = socket;
    }

    @Override
    public void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                File path = FileUtils.createFile();
                //while (line.equals(":end")) {
                    try (FileWriter writer = new FileWriter(path, true)) {
                        writer.append(line);
                    }
                //}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(":end");
    }
}
