/**
 * Action Server - (Socket Programming)
 * <p>
 * CO225 - Software Construction - Lab 09
 * <p>
 * Developer : K. A. D. Nadeeshan - dinuka.nadeeshan1993@gmail.com
 * <p>
 * &#169; Unicorn Inc.(TM)
 */

import java.io.*;
import java.util.ArrayList;

public class FileHandeler {
    private static ArrayList<Item> stock;
    private static MainServerForm serverForm;

    static {
        stock = new ArrayList<>();
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader("./src/stocks.csv");
            br = new BufferedReader(fr);

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] stringParts = line.split(",");
                try {
                    stock.add(new Item(stringParts[0], stringParts[1], Double.parseDouble(stringParts[2])));
                } catch (NumberFormatException e) {
                    stock.add(new Item(stringParts[0], stringParts[1], 0));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //    public static void setServerForm(MainServerForm serverForm) {
//        thi
//    }
    public static synchronized Item getItem(String symbol) {
        for (Item item :
                stock) {
            if (item.equals(symbol)) return item;
        }
        return null;
    }

    public static synchronized double getUnitPriceFor(String symbol) {
        return getItem(symbol).getPrice();
    }

    public static synchronized boolean updatePrice(String symbol, double price) {
        for (int i = 0; i < stock.size(); i++) {
            Item item = stock.get(i);
            if (item.getSymbol().equals(symbol)) {
                if (item.getPrice() < price) {
                    item.setPrice(price);
                    serverForm.updatePrice(symbol, price);
                    return true;
                } else {
                    return false;
                }

            }
        }
        return false;
    }

    public static void setServerForm(MainServerForm serverForm) {
        FileHandeler.serverForm = serverForm;
    }
}
