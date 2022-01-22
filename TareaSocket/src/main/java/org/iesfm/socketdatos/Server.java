package org.iesfm.socketdatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Binding;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        int serverPort = 4000;
        try {
            ServerSocket ss = new ServerSocket(serverPort);
            Socket socket = ss.accept();
            Thread serverTask = new Thread(new ServerTask(socket));
            serverTask.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
