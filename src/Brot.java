import java.util.ArrayList;

public class Brot extends Lebensmittel implements Cloneable {
    // Exemplarvariablen für Brote:
    private String breadType;

    public Brot(String productName, double price, long productNumber,int restHaltbarkeit, String breadType) {
        super(productName, price, productNumber,restHaltbarkeit);
        this.breadType = breadType;
    }

    public String getBreadType() {
        return breadType;
    }

    @Override
    public ArrayList<String> getProductInfo() {
        ArrayList<String> productInfo = new ArrayList<>();
        productInfo.addAll(super.getProductInfo());
        productInfo.add("Bread Type: " + breadType);
        return productInfo;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
