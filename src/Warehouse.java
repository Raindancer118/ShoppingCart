import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Warehouse {
    private int warehouseID;
    private ArrayList<Product> registeredProducts;

    // Konstruktor für Warehouse:
    public Warehouse(int ID) {
        this.warehouseID = ID;
        registeredProducts = new ArrayList<>();
    }

    // Methode zur Registrierung von Produkten im Warenhaus
    public void register(Product p) {
        boolean found = false;
        Product toAdd = p;
        try {
            toAdd = (Product) p.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone not supported");
        }
        for (int i = 0; i < registeredProducts.size(); i++) {
            if (registeredProducts.get(i).getProductID() == p.getProductID()) {
                found = true;
            }
        }
        if (!found) {
            registeredProducts.add(toAdd);
            System.out.println(p.getProductID() + " was registered in the warehouse");
        }
        else JOptionPane.showMessageDialog(null, "The product number " + p.getProductID() + " is already registered in the warehouse");
    }

    // Methode zur Entfernung von registrierten Produkten aus dem Warenhaus
    public void unregister(Product p) {
        boolean found = false;
        for (int i = 0; i < registeredProducts.size(); i++) {
            if (registeredProducts.get(i).getProductID() == p.getProductID()) {
                found = true;
            }
        }
        if (found) {
            registeredProducts.remove(p);
        }
        else {
            JOptionPane.showMessageDialog(null, "The product number " + p.getProductID() + " is not registered in the warehouse");
        }
    }

    // Methode zur Entfernung von Produkten aus dem Warenhaus anhand der Produkt-ID:
    public void unregister(long ProductID) {
        boolean found = false;
        Product toRemove = null;
        for (int i = 0; i < registeredProducts.size(); i++) {
            if (registeredProducts.get(i).getProductID() == ProductID) {
                found = true;
                toRemove = registeredProducts.get(i);
            }
        }
        if (found) {
            registeredProducts.remove(toRemove);
        }
        else JOptionPane.showMessageDialog(null, "The product number " + ProductID + " is not registered in the warehouse");
    }

    public ArrayList<Product> getRegisteredProducts() {
        return registeredProducts;
    }
}
