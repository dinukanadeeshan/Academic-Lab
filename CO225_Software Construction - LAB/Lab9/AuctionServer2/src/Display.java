import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class Display extends JPanel implements ActionListener{
    JLabel [] symbolLabels = new JLabel[8];
    JLabel [] nameLabels = new JLabel[8];
    JLabel [] priceLabels = new JLabel[8];
    JButton [] historyBtns = new JButton[8];

    private MainServer server;
    public Display(MainServer server){
        this.server = server;
        setLayout(new GridLayout(8,4));

        symbolLabels[0] = new JLabel("FB");
        symbolLabels[1] = new JLabel("VRTU");
        symbolLabels[2] = new JLabel("MSFT");
        symbolLabels[3] = new JLabel("GOOGL");
        symbolLabels[4] = new JLabel("YHOO");
        symbolLabels[5] = new JLabel("XLNX");
        symbolLabels[6] = new JLabel("TSLA");
        symbolLabels[7] = new JLabel("TXN");

        nameLabels[0] = new JLabel("Facebook");
        nameLabels[1] = new JLabel("Virtusa Corporation - common stock");
        nameLabels[2] = new JLabel("Microsoft Corporation - Common Stock");
        nameLabels[3] = new JLabel("Google Inc. - Class A Common Stock");
        nameLabels[4] = new JLabel("Yahoo! Inc. - Common Stock");
        nameLabels[5] = new JLabel("Xilinx");
        nameLabels[6] = new JLabel("Tesla Motors");
        nameLabels[7] = new JLabel("Texas Instruments Incorporated - Common Stock");

        priceLabels[0] = new JLabel("");
        priceLabels[1] = new JLabel("");
        priceLabels[2] = new JLabel("");
        priceLabels[3] = new JLabel("");
        priceLabels[4] = new JLabel("");
        priceLabels[5] = new JLabel("");
        priceLabels[6] = new JLabel("");
        priceLabels[7] = new JLabel("");

        for (int i = 0; i < 8; i++) {
            historyBtns[i]=new JButton("View History");
            historyBtns[i].setActionCommand(symbolLabels[i].getText());
            historyBtns[i].addActionListener(new BtnClickAction());
            priceLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            nameLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            symbolLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) add(symbolLabels[i]);
                if (j == 1) add(nameLabels[i]);
                if (j == 2) add(priceLabels[i]);
                if (j == 3) add(historyBtns[i]);
            }
        }

        Timer timer = new Timer(500, this);
        timer.start();

        for (int i = 0; i < 8; i++) {
            Item item = server.stock.findItem(symbolLabels[i].getText());
            if (item != null) priceLabels[i].setText(item.getPrice()+"");
        }

    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        MainServer server = new MainServer(2000, new StockDB("stocks.csv"));
        new Thread(){
            @Override
            public void run() {
                try {
                    server.startServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        frame.add(new Display(server));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 8; i++) {
            ArrayList<Double> list = server.bidList.get(symbolLabels[i].getText());
            if (list != null && !list.isEmpty())
                priceLabels[i].setText(
                        list.get(list.size()-1)+"");
        }
    }


    class  BtnClickAction implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            String sym = e.getActionCommand();
            JList list = new JList(new DefaultListModel());
            ArrayList<Double> bids = MainServer.bidList.get(sym);
            if (bids != null) {
                for (int i = 0; i < bids.size(); i++) {
                    DefaultListModel model = (DefaultListModel) list.getModel();
                    model.addElement(bids.get(i));
                }
            }
            JOptionPane.showMessageDialog(Display.this, list);
        }
    }
}
