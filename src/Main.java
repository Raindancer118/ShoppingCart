public class Main {
    public static void main(String[] args) {
        Product vollkornBrot = new Brot("Vollkornbrot",1.99,234328,16,"Vollkorn");
        Product weizenbrot = new Brot("Weizenbrot",0.99,36372,10,"Weizen");
        Product Dinkelvollkorn = new Brot("Dinkelvollkorn",1.99,234328,16,"Dinkelvollkorn");
        Warehouse WH1 = new Warehouse(1);
        WH1.register(vollkornBrot);
        WH1.register(weizenbrot);
        vollkornBrot.timeTick(40);
        ShoppingCart cart = new ShoppingCart(WH1);
        cart.addToCart(weizenbrot);
        cart.addToCart(vollkornBrot);
        cart.addToCart(Dinkelvollkorn);
        cart.actionPanel();


    }
}