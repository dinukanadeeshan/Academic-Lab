/**
 *  Action Server - (Socket Programming)
 *
 *  CO225 - Software Construction - Lab 09
 *
 *  Developer : K. A. D. Nadeeshan - dinuka.nadeeshan1993@gmail.com
 *
 *  &#169; Unicorn Inc.(TM)
 */


public class Item {
    private String symbol;
    private String securityName;
    private double price;

    public Item() {
    }

    public Item(String symbol, String securityName, double price) {
        this.symbol = symbol;
        this.securityName = securityName;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            return symbol.equals(obj);
        }
        return false;
    }

    @Override
    public String toString() {
        return symbol + ": \t" + securityName + ": \t" + price;
    }
}
