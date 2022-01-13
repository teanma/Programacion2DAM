package org.iesfm.socketdatos;

import java.io.*;
import java.net.Socket;

public class ServerTask implements Runnable {

    private Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        File path = FileUtils.askForFilePath();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                try (PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
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
