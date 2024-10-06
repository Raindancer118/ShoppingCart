import javax.swing.*;
import java.util.ArrayList;

public abstract class Lebensmittel extends Product implements Cloneable{
    // Exemplarvariablen für Lebensmittel
    private boolean istSchlecht;

    public Lebensmittel(String productName, double price, long productNumber, int restHaltbarkeit) {
        super(productName, price, productNumber, restHaltbarkeit);
    }

    public boolean isIstSchlecht() {
        return istSchlecht;
    }

    public void istSchlecht() {
        if (super.getRestHaltbarkeit() <= 0) {
            istSchlecht = true;
            JOptionPane.showMessageDialog(null,"Dein "+super.getProductName()+" ist schlecht geworden!");
            System.out.println("istSchlecht: Dein "+super.getProductName()+" ist schlecht geworden!");
        }
    }

    public void timeTick(int numberOfDays){
        super.timeTick(numberOfDays);
        istSchlecht();
    }

    public void timeTick(){
        super.timeTick();
        istSchlecht();
    }

    @Override
    public ArrayList<String> getProductInfo() {
        ArrayList<String> productInfo = new ArrayList<>();
        productInfo.addAll(super.getProductInfo());
        productInfo.add("Ist Schlecht: "+istSchlecht);
        return productInfo;
    }
}
