package Lesson_6.server;

public class StartServer {
    public static void main(String[] args) {
        ServerHandler serverHandler =  new ServerHandler();

        while (!serverHandler.getClients().isEmpty()) {
            for (int i = 0; i < serverHandler.getClients().size(); i++) {
                if(serverHandler.getClients().get(i).getSocket().isClosed()) {
                    serverHandler.closeCurrentClient(serverHandler.getClients().get(i));
                }
            }
        }
    }
}
