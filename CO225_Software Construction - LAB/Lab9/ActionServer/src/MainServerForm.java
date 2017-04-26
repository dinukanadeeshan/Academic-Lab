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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainServerForm extends JFrame {

    private static final int PORT = 2000;
    private DefaultListModel clientListModel;
    private DefaultListModel itemListModel;

    private JButton startBtn;
    private JButton stopBtn;

    private SocketServer server;

    private JList clientList;

    private JList itemList;

    private JTextArea logginTxtArea;
    private String itemSymbols[] = {"FB", "VRTU", "MSFT", "GOOGL", "YHOO", "XLNX", "TSLA", "TXN"};

    private JButton clearBtn;

    public MainServerForm() {
        super("Server Utilities");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        FileHandeler.setServerForm(this);

        startBtn = new JButton("Start Server");
        stopBtn = new JButton("Stop Server");
        stopBtn.setEnabled(false);

        JPanel btnPanel = new JPanel();
        btnPanel.add(startBtn);
        btnPanel.add(stopBtn);


        add(BorderLayout.NORTH, btnPanel);

        startBtn.addActionListener(this::startBtnAction);
        stopBtn.addActionListener(this::stopBtnAction);

        clientList = new JList(new DefaultListModel());
        clientList.setCellRenderer(new CustomizedClientListCellRenderer());
        JPanel clientListPnl = new JPanel();

        clientListModel = (DefaultListModel) clientList.getModel();

        clientListPnl.add(clientList);
        add(BorderLayout.WEST, clientListPnl);
        itemListModel = new DefaultListModel();
        itemList = new JList(itemListModel);
        itemList.setCellRenderer(new CustomizedItemListCellRenderer());
        addItemToList();

        JPanel itemListPanel = new JPanel();
        itemListPanel.add(itemList);


        JPanel logPanel = new JPanel(new BorderLayout());
        logginTxtArea = new JTextArea(10, 50);
        logginTxtArea.setEditable(false);
        logPanel.add(new JScrollPane(logginTxtArea));

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this::clearBtnAction);
        JPanel temp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        temp.add(clearBtn);
        logPanel.add(BorderLayout.SOUTH, temp);
        JPanel centerPnl = new JPanel();
        centerPnl.add(itemListPanel);
        centerPnl.add(logPanel);

        LogActions.setTextArea(logginTxtArea);
        add(BorderLayout.CENTER, centerPnl);

    }

    private void addItemToList() {
        for (String sym :
                itemSymbols) {
            itemListModel.addElement(FileHandeler.getItem(sym));
        }
    }


    public void updatePrice(String symbol, double price) {
        //((Item) itemListModel.get(1)).setPrice(102);
        for (int i = 0; i < itemListModel.size(); i++) {
            Item item = (Item) itemListModel.get(i);
            if (item.getSymbol().equals(symbol)) {
                // if (item.getPrice() < price) {

                item.setPrice(price);
                itemListModel.remove(i);
                itemListModel.add(i, item);

                for (int j = 0; j < clientListModel.size(); j++) {
                    Client c = (Client) clientListModel.get(j);
                    if (c.getSym().equals(symbol)) c.pushMsg(symbol + " price changed " + price);
                }
                break;
                //}

            }
        }
    }

    private void clearBtnAction(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(this, "Are you sure?", "", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION)
            logginTxtArea.setText("");
    }

    private void startBtnAction(ActionEvent e) {
        try {
            server = new SocketServer(PORT, clientListModel);

            LogActions.log("Server Started...");
            startBtn.setEnabled(false);
            stopBtn.setEnabled(true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    private void stopBtnAction(ActionEvent e) {
        try {
            server.clearAll();
            LogActions.log("Shutdown server...");
            startBtn.setEnabled(true);
            stopBtn.setEnabled(false);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainServerForm().setVisible(true);
    }

    class CustomizedClientListCellRenderer extends DefaultListCellRenderer {
        private Font f = new Font("", 1, 16);

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {

            Component listCellRendererComponent = super.getListCellRendererComponent(list, value, index, isSelected,
                    cellHasFocus);
            listCellRendererComponent.setFont(f);
            return listCellRendererComponent;
        }
    }

    class CustomizedItemListCellRenderer extends DefaultListCellRenderer {
        private JPanel pnl;
        private JLabel symLbl;
        private JLabel nameLbl;
        private JLabel priceLbl;

        private Font f1 = new Font("", Font.BOLD, 16);
        private Font f2 = new Font("", Font.BOLD, 12);

        public CustomizedItemListCellRenderer() {


        }


        @Override

        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            Component listCellRendererComponent = super.getListCellRendererComponent(list, value, index, isSelected,
                    cellHasFocus);

            if (value instanceof Item) {
                pnl = new JPanel(new GridLayout(1, 3, 5, 100));
                pnl.setOpaque(true);
                pnl.setBackground(Color.white);
                pnl.setPreferredSize(new Dimension(600, 30));
                symLbl = new JLabel();
                symLbl.setBackground(Color.lightGray);
                symLbl.setHorizontalAlignment(CENTER);
                symLbl.setOpaque(true);
                nameLbl = new JLabel();
                nameLbl.setBackground(Color.gray);
                nameLbl.setForeground(Color.white);
                nameLbl.setHorizontalAlignment(CENTER);
                nameLbl.setOpaque(true);
                priceLbl = new JLabel();
                priceLbl.setBackground(Color.darkGray);
                priceLbl.setForeground(Color.white);
                priceLbl.setHorizontalAlignment(CENTER);
                priceLbl.setOpaque(true);
                symLbl.setFont(f2);
                nameLbl.setFont(f2);
                priceLbl.setFont(f1);
                Component add = new JPanel().add(symLbl);
                // add.setPreferredSize(new Dimension(10,30));
                pnl.add(add);
                //nameLbl.setPreferredSize(new Dimension(200,50));
                pnl.add(nameLbl);
                pnl.add(priceLbl);

                Item item = (Item) value;
                symLbl.setText(item.getSymbol());
                nameLbl.setText(item.getSecurityName());
                priceLbl.setText(item.getPrice() + "");
                return pnl;
            }
            return listCellRendererComponent;
        }
    }

}
