package t3;

import java.util.ArrayList;
import java.util.List;

/**
 * Online Shop Management System (OSMS)
 * This class manages the inventory of products and customers in an online shop.
 */
public class OSMS {
    // Lists to store products and customers
    private List<Product> inventory = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();


    public void addProduct(Product product) {
        inventory.add(product);
    }

    /**
     * Removes a product from the shop inventory
     */
    public boolean removeProduct(Product product) {
        boolean removed = false;
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            if (p.getProductName().equals(product.getProductName()) &&
                    p.getPrice() == product.getPrice()) {
                inventory.remove(i);
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Registers a new customer in the system
     */
    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Removes a customer from the system
     */
    public boolean removeCustomer(Customer customer) {
        boolean removed = false;
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.getEmail().equals(customer.getEmail())) {
                customers.remove(i);
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Processes a purchase for a customer
     */
    public void processPurchase(Customer customer, Product product) {
        if (inventory.contains(product)) {
            customer.addPurchasedProduct(product);
            // Optionally remove the product from inventory if it's a one-time sale
            // removeProduct(product);
            System.out.println("Purchase successful: " + customer.getName() +
                    " bought " + product.getProductName());
        } else {
            System.out.println("Product not available in inventory");
        }
    }

    /**
     * Prints all products in the inventory
     */
    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("The inventory is empty");
        } else {
            System.out.println("Current Inventory:");
            for (Product p : inventory) {
                System.out.println(p);
            }
            System.out.println();
        }
    }

    /**
     * Prints all registered customers
     */
    public void printCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered");
        } else {
            System.out.println("Registered Customers:");
            for (Customer c : customers) {
                System.out.println(c);
                System.out.println("Total Savings: $" + String.format("%.2f", c.getTotalSavings()));
                System.out.println("Purchased Products:");

                List<Product> purchasedProducts = c.getPurchasedProducts();
                if (purchasedProducts.isEmpty()) {
                    System.out.println("  None");
                } else {
                    for (Product p : purchasedProducts) {
                        System.out.println("  - " + p);
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * Applies a discount to all products in a specific category
     */
    public void applyDiscountToCategory(String category, double discount) {
        for (Product p : inventory) {
            // Assuming the Product class has a getCategory method, which you'd need to add
            // if (p.getCategory().equals(category)) {
            //     p.setDiscountPercentage(discount);
            // }

            // Since your Product class doesn't have a category field, you could
            // use product name matching as an alternative approach:
            if (p.getProductName().toLowerCase().contains(category.toLowerCase())) {
                p.setDiscountPercentage(discount);
            }
        }
    }
}