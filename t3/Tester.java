package t3;

public class Tester {
    public static void main(String[] args) {
        // Create the online shop management system
        OSMS shop = new OSMS();

        // Create products
        Product p1 = new Product();
        p1.setProductName("Charger");
        p1.setPrice(12.97);
        p1.setDiscountPercentage(5);

        Product p2 = new Product();
        p2.setProductName("Headphones");
        p2.setPrice(29.99);
        p2.setDiscountPercentage(10);

        Product p3 = new Product();
        p3.setProductName("USB Cable");
        p3.setPrice(7.50);
        p3.setDiscountPercentage(0);

        // Add products to inventory
        shop.addProduct(p1);
        shop.addProduct(p2);
        shop.addProduct(p3);

        // Create customers
        Customer c1 = new Customer();
        c1.setName("Zaali");
        c1.setSurname("Injgia");
        c1.setEmail("zaali.injgia.1@iliauni.edu.ge");

        Customer c2 = new Customer();
        c2.setName("John");
        c2.setSurname("Doe");
        c2.setEmail("john.doe@example.com");

        // Register customers
        shop.registerCustomer(c1);
        shop.registerCustomer(c2);

        // Process some purchases
        shop.processPurchase(c1, p1);
        shop.processPurchase(c1, p2);
        shop.processPurchase(c2, p3);

        // Print inventory and customers
        shop.printInventory();
        shop.printCustomers();

        // Apply discount to all charging products
        shop.applyDiscountToCategory("Charger", 15);
        System.out.println("After applying 15% discount to charging products:");
        shop.printInventory();
    }
}