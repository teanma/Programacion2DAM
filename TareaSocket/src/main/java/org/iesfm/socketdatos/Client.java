package org.iesfm.socketdatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final static Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4000);
            Scanner scan = new Scanner(System.in);
            ClientTask clientTask = new ClientTask(scan, socket);
            clientTask.run();
        } catch (IOException e) {
            log.error("Error al conectarse", e);
        }
    }
}
