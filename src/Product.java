import javax.swing.JOptionPane;
import java.util.ArrayList;

public abstract class Product implements Comparable<Product> {
    private String productName;
    private double price;
    private int quantity;
    private long productID;
    private int restHaltbarkeit;

    ;
    public Product(String productName, double price,long productNumber,int restHaltbarkeit) {
        this.productName = productName;
        this.price = price;
        this.quantity = 1;
        this.productID = productNumber;
        this.restHaltbarkeit = restHaltbarkeit;
        JOptionPane.showMessageDialog(null,"Created product "+productName+" with price "+price+"€ and product number "+productNumber);
    }

    public long getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getRestHaltbarkeit() {
        return restHaltbarkeit;
    }

    public void timeTick(int numberOfDays){
        restHaltbarkeit = restHaltbarkeit - numberOfDays;
        System.out.println("TimeTick: Es sind "+numberOfDays+" Tage vergangen.");
    }

    public void timeTick(){
        restHaltbarkeit--;
        System.out.println("TimeTick: Es ist ein Tag vergangen.");
    }

    public ArrayList<String> getProductInfo() {
        ArrayList<String> productInfo = new ArrayList<>();
        productInfo.add("Product Name: "+productName);
        productInfo.add("Price: "+Double.toString(price)+"€");
        productInfo.add("Quantity: "+Integer.toString(quantity));
        productInfo.add("Product ID: "+Long.toString(productID));
        if (restHaltbarkeit > 0) productInfo.add("Resthaltbarkeit: "+restHaltbarkeit);
        return productInfo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
