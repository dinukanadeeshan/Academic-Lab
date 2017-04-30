import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StockDB {

    private Map<String, Item> stock;
    private String [] fields;

    public StockDB(String cvsFile)  {
        FileReader fileRd=null;
        BufferedReader reader=null;

        try {
            fileRd = new FileReader(new File("./"+cvsFile));
            reader = new BufferedReader(fileRd);

	    /* read the CSV file's first line which has
	     * the names of fields.
	     */

            String header = reader.readLine();
            fields = header.split(",");// keep field names


            // get a new hash map
            stock = new HashMap<>();

	    /* read each line, getting it split by ,
	     * use the indexes to get the key and value
	     */
            String [] tokens;
            for(String line = reader.readLine();
                line != null;
                line = reader.readLine()) {
                tokens = line.split(",");
                double price  = 0;
                try{price = Double.parseDouble(tokens[2]);}catch (NumberFormatException e){}
                stock.put(tokens[0], new Item(tokens[0], tokens[1], price));
            }

            if(fileRd != null) fileRd.close();
            if(reader != null) reader.close();

            // I can catch more than one exceptions
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Malformed CSV file");
            System.out.println(e);
        }
    }

    private int findIndexOf(String key) {
        for(int i=0; i < fields.length; i++)
            if(fields[i].equals(key)) return i;
        return -1;
    }


    public Item findItem(String key) {
        return stock.get(key);
    }

}

class Item{
    private String symbol;
    private String name;
    private double price;

    public Item(String symbol, String name, double price) {
        this.setSymbol(symbol);
        this.setName(name);
        this.setPrice(price);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}