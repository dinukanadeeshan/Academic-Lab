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
import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Client implements Runnable {
    private Socket socket;
    private DefaultListModel model;
    private String name;
    private String sym;
    private SocketServer socketServer;
    private BufferedReader in;
    private BufferedWriter out;

    public String getSym() {
        return sym;
    }

    public Client(Socket socket, SocketServer socketServer, ListModel model) {
        this.socketServer = socketServer;
        this.socket = socket;

        this.model = (DefaultListModel) model;
    }


    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            out.write("Enter your name : ");
            out.flush();

            name = in.readLine();
            model.addElement(this);
            String line;
            LogActions.log(name + " is connected.");
            out.write("Enter Symbol that you willing to bid on : ");

            out.flush();


            line = in.readLine();
            double currCost = FileHandeler.getUnitPriceFor(line);
            while ((currCost == -1)) {
                out.write("-1 : Invalid Input! Enter Symbol that you willing to bid on : ");
                out.flush();
                line = in.readLine();
                currCost = FileHandeler.getUnitPriceFor(line);
            }
            sym = line;
            out.write("Current cost of " + line + " is : " + currCost);
            out.newLine();
            out.flush();
            LogActions.log(name + " selected " + line);


            //Handle biding loop
            while ((line = in.readLine()) != null) {

                try {
                    if (FileHandeler.updatePrice(sym, Double.parseDouble(line))) {
                        LogActions.log(name + " : " + line);
                        //out.write("Posted : " + line);
//                        out.newLine();
//                        out.flush();
                    } else {
                        LogActions.log(name + " : " + line + " :  Invalid bid...");
                        out.write(" Invalid bid... " + line);
                        out.newLine();
                        out.flush();
                    }


                } catch (NumberFormatException e) {
                    out.write("Invalid input!");
                    out.newLine();
                    out.flush();

                    continue;
                }
            }

            LogActions.log(name + " is disconnected");
        } catch (SocketException e) {
            if (e.getMessage().contains("Socket closed"))
                LogActions.log(name + " is disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
                socketServer.removeClient(this);
                model.removeElement(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() throws IOException {
        socket.close();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void pushMsg(String msg) {
        try {
            out.write(msg);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "** " + name;
    }
}
