package org.iesfm.socketchat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

    public static void main(String[] args) {
        String serverIp = "localhost";
        int serverPort = 4000;

        try {
            Socket socket = new Socket(serverIp, serverPort);
            ReadMessageTask readMessageTask = new ReadMessageTask(socket);
            readMessageTask.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
