package Lesson_6.server;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerHandler {
    private Vector<ClientHandler> clients;

    public ServerHandler() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Server started!");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected!");
                subscribe(new ClientHandler(socket, this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void subscribe (ClientHandler client) {
        clients.add(client);
    }
    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public void broadCastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

}
