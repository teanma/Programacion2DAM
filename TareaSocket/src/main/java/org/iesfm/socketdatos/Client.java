package org.iesfm.socketdatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final static Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        String serverIp = "localhost";
        int serverPort = 4000;

        try {
            Socket socket = new Socket(serverIp, serverPort);
            Scanner scanner = new Scanner(System.in);
            Thread clientTask = new Thread(new ClientTask(scanner, socket));
            clientTask.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
