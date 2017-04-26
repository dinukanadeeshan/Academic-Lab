/**
 * Action Server - (Socket Programming)
 * <p>
 * CO225 - Software Construction - Lab 09
 * <p>
 * Developer : K. A. D. Nadeeshan - dinuka.nadeeshan1993@gmail.com
 * <p>
 * &#169; Unicorn Inc.(TM)
 */

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class SocketServer {

    private ArrayList<Client> clients;

    private ServerSocket serverSocket;

    public SocketServer(int port, ListModel model) throws IOException {
        clients = new ArrayList<>();
        serverSocket = new ServerSocket(port);

        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    Client client = new Client(socket, this, model);
                    clients.add(client);
                    new Thread(client).start();
                } catch (IOException e) {
                    break;
                }
            }
        }).start();
    }

    public void addClient(Client client) {
        clients.add(client);
    }


    public void removeClient(String name) throws IOException {
        for (int i = 0; i < clients.size(); i++) {
            Client c = clients.get(i);
            if (c.getName().equals(name)) {
                c.close();
                clients.remove(c);
                break;
            }
        }
    }

    public void removeClient(Client client) {
        clients.remove(client);

    }

    public void clearAll() throws IOException {

        serverSocket.close();

        for (Client c :
                clients) {
            c.close();

        }
        int noOfClients = clients.size();
        for (int i = 0; i < noOfClients; i++) {
            clients.remove(0);
        }
    }
}
