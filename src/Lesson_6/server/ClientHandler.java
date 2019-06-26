package Lesson_6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ServerHandler server;
    private String nick;

    public ClientHandler(Socket socket, ServerHandler server) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true) {
                            String inputString = in.readUTF();
                            if (inputString.startsWith("/auth")) {
                                String [] tokens = inputString.split(" ");
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                if(server.alreadyConnected(newNick)) {
                                    sendMsg("User already connected!");
                                } else if(newNick != null && !server.alreadyConnected(newNick)) {
                                    sendMsg("/authok");
                                    nick = newNick;
                                    server.subscribe(ClientHandler.this);
                                    break;
                                } else {
                                    sendMsg("Wrong login/password!");
                                }
                            }
                            //server.broadCastMsg(inputString);
                        }

                        while (true) {
                            String inputString = in.readUTF();
                            if (inputString.equals("/end")) {
                                out.writeUTF("/serverclosed");
                                break;
                            }
                            if (inputString.startsWith("/w")) {
                                String [] splitedMsg = inputString.split(" ");
                                server.privateMessage(nick,splitedMsg[1],splitedMsg[2]);
                            } else {
                                server.broadCastMsg(nick + ":" + inputString);
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    server.unsubscribe(ClientHandler.this);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }
}
