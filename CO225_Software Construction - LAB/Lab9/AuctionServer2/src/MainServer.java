import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainServer extends Thread {
    public static StockDB stock;
    public static Map<String, ArrayList<Double>> bidList;
    private ServerSocket server;

    private Socket socket;
    private String name;
    private String sym;

    public MainServer(Socket socket){
        this.socket = socket;
    }

    public MainServer(int port, StockDB stock) throws IOException {
        this.stock = stock;
        server = new ServerSocket(port);
        bidList = new HashMap<>();
    }

    public void startServer() throws IOException {
        while (true) {
            Socket s = server.accept();
            new MainServer(s).start();
        }
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new
                    BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new
                    PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.println("Enter your Name");
            out.flush();
            String line, outline;
            line = in.readLine();
            name = line;
            out.println("Enter symbol");
            out.flush();
            line = in.readLine();
            sym = line;
            for (line = in.readLine(); line != null && !line.equals("quit"); line = in.readLine()) {
                if (!bidList.containsKey(sym)) {
                    bidList.put(sym, new ArrayList<>());
                }
                ArrayList<Double> list = bidList.get(sym);
                if (!list.isEmpty() && list.get(list.size()-1) < Double.parseDouble(line)){
                    list.add(Double.parseDouble(line));

                }
                if (list.isEmpty() && stock.findItem(sym).getPrice() < Double.parseDouble(line)) {
                    list.add(Double.parseDouble(line));


                }
            }


            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
