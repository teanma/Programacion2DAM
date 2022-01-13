package org.iesfm.socketdatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Binding;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final static Logger log = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4000);
            Socket socket = ss.accept();
            ServerTask serverTask = new ServerTask(socket);
            serverTask.run();
        } catch (BindException e) {
            log.error("El puerto 4000 ya está en uso", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
