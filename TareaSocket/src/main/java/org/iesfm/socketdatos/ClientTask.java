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
        File path = FileUtils.createFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                try (PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
                    String message = scan.nextLine();
                    writer.println(message);
                    writer.println(line);
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(":end");
    }
}
