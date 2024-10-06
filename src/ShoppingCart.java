import javax.swing.*;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> cart = new ArrayList<>();
    private Warehouse warehouse;

    public ShoppingCart(Warehouse warehouse) {
        this.cart.clear();
        this.warehouse = warehouse;
    }

    public void addToCart(Product product) {
        boolean exists = false;
        for (int i = 0; i < warehouse.getRegisteredProducts().size(); i++) {
            if (product.getProductID() == warehouse.getRegisteredProducts().get(i).getProductID()) {
                exists = true;
                for (int j = 0; j < cart.size(); j++) {
                    if (cart.get(j).getProductID() == product.getProductID()) {
                        cart.get(j).setQuantity(cart.get(j).getQuantity() + 1);
                        return;
                    }
                }
                cart.add(product);
            }
        }
        if (!exists) {
            JOptionPane.showMessageDialog(null, "Product " + product.getProductID() + " does not exist!");
        }
    }

    public void addToCart(long productID) {
        boolean exists = false;
        Product toAdd = null;
        for (int i = 0; i < warehouse.getRegisteredProducts().size(); i++) {
            if (productID == warehouse.getRegisteredProducts().get(i).getProductID()) {
                exists = true;
                for (int j = 0; j < cart.size(); j++) {
                    if (cart.get(j).getProductID() == productID) {
                        cart.get(j).setQuantity(cart.get(j).getQuantity() + 1);
                        return;
                    }
                }
                toAdd = warehouse.getRegisteredProducts().get(i);
                cart.add(toAdd);
                JOptionPane.showMessageDialog(null, "Product " + productID + " added to shopping cart!");
            }
        }
        if (!exists) {
            JOptionPane.showMessageDialog(null, "Product " + productID + " does not exist!");
        }
    }

    // clear cart
    public void clear() {
        this.cart.clear();
    }

    // Methode zum Entfernen einzelner Produkte aus dem Warenkorb
    public void removeFromCart(Product product) {
        boolean found = false;
        for (int i = 0; i < warehouse.getRegisteredProducts().size(); i++) {
            if (product.getProductID() == warehouse.getRegisteredProducts().get(i).getProductID()) {
                found = true;
                cart.remove(product);
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Product " + product.getProductID() + " is not in cart!");
        }
    }


    public void removeFromCart(long productID) {
        boolean found = false;
        Product toRemove = null;
        for (int i = 0; i < warehouse.getRegisteredProducts().size(); i++) {
            if (productID == warehouse.getRegisteredProducts().get(i).getProductID()) {
                found = true;
                toRemove = warehouse.getRegisteredProducts().get(i);
                cart.remove(toRemove);
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Product " + productID + " is not in cart!");
        }
    }

    public void printCart() {
        System.out.println();
        System.out.println("-------------------------------- YOUR CART ---------------------------------");
        try {
            for (int i = 0; i < cart.size(); i++) {
                for (int j = 0; j < cart.get(i).getProductInfo().size(); j++) {
                    System.out.println(cart.get(i).getProductInfo().get(j));
                }
                System.out.println("          -----------------------           ");
            }
        }catch(NullPointerException e) {
            System.out.println("Ran into a Problem. Please try again!");
        }finally {
        }
    }

    public void actionPanel() {
        String[] options = new String[]{
                "Add Product to Cart",
                "Remove Product from Cart",
                "Clear Cart", "End Program",
                "Print Cart"
        };
        int choice = JOptionPane.showOptionDialog(null,
                "Chose your Action to continue!",
                "ActionPanel",
                0,
                3,
                null,
                options,
                options[0]);
        decider(choice);
    }

    public long productSelector(){
        String[] options = new String[warehouse.getRegisteredProducts().size()];
        for (int i = 0; i < warehouse.getRegisteredProducts().size(); i++) {
            options[i] = warehouse.getRegisteredProducts().get(i).getProductName();
        }
        int decision = JOptionPane.showOptionDialog(null,"Select a product to continue.","ProductSelector",0,3,null,options,options[0]);
        long productID = warehouse.getRegisteredProducts().get(decision).getProductID();
        return productID;
    }

    public void decider(int choice) {
        long productID;
        switch (choice) {
            case 0:
                productID = productSelector();
                addToCart(productID);
                break;
                case 1:
                    productID = productSelector();
                    removeFromCart(productID);
                    break;
                    case 2:
                        clear();
                        break;
                        case 3:
                            JOptionPane.showMessageDialog(null,"Bis bald!","Shutting down...",JOptionPane.INFORMATION_MESSAGE);
                            System.out.println("Shutting down...");
                            System.exit(0);
                            break;
                            case 4:
                                printCart();
                                break;
                                default:
                                    break;
        }
        actionPanel();
    }

}
