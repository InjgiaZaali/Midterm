# Online Store Management System

Masterclass in Java

## Description

Create Online Store Management System (OSMS) in Java. OSMS is widely used software. It can be any complexity. Our example is a basic one, which has the following features:

1. storage for products
2. ability to add products to the store
3. ability to remove products from the store
4. ability to register customers
5. ability to process purchases
6. ability to print the store inventory and customer information on the console

## OSMS structure

We will need the following classes for the software:

1. Product – the product itself.
2. Customer – the customer who can purchase products.
3. OSMS – online store management system.
4. Tester – the tester class. This class will be used to test our management system.

## Class Product

The class Product should have several fields, including productName and price. This class can be implemented in the following way:

```java
package t3;

/**
 * Represents a product in the online store.
 */
public class Product {
    private String productName;
    private double price;
    private double discountPercentage;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            this.discountPercentage = discountPercentage;
        } else {
            System.out.println("Invalid discount percentage. Must be between 0 and 100.");
        }
    }
    public double getFinalPrice(){
        return price * (1 - discountPercentage / 100);
    }
    @Override
    public String toString() {
        if (discountPercentage > 0){
            return productName + ("Original: $" + price + ", Discount: " + discountPercentage + "%, Final: $" + String.format("%.2f", getFinalPrice()) + ")");
        }else {
            return productName + " ($" + price + ")";
        }

    }
}
```

Pay attention to the setters and getters of the fields. In general, all the fields are private (unless the special requirements are stated) and the access functions are implemented such as setters and getters.

Also note the implementation of toString() function for the Product class, which provides a formatted string representation of the product.

## Class Customer

The customer class should track information about the store's customers, including their personal details and purchase history. The class can be implemented in the following way:

```java
package t3;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private String email;

    private List<Product> purchasedProducts = new ArrayList<>();
    private double totalSavings = 0;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * NEW FEATURE: Customer Savings Tracking
     * This feature tracks the total amount each customer has saved through product discounts.
     * It automatically calculates savings for each purchase and maintains a running total.
     */
    public void addPurchasedProduct(Product product) {
        purchasedProducts.add(product);
        double savings = product.getPrice() - product.getFinalPrice();
        totalSavings += savings;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public double getTotalSavings() {
        return totalSavings;
    }

    public String toString() {
        return name + " " + surname + " (" + email + ")";
    }
}
```

Pay attention to the implementation of the customer's purchase history with a List of products and the calculation of savings from discounts.

## Class OSMS

The online store management system should have an inner structure for storing products and customers. The management system should have methods for adding new products and removing the old ones, registering customers, processing purchases, and applying discounts. It should have the ability to print the entire store inventory and customer information when needed. The class can be implemented in the following way:

```java
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
```

Pay attention to the usage of the ArrayList class, for loops for the lists, break clause, and the String object comparison. Usage of the boolean variables can also be observed in this example.

## OSMS Tester class

Now let's test our management system. First, create some products. Then create customers and register them with the OSMS. Add the products to the inventory and process some purchases.

```java
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
```

We print the state of the inventory and customer information to check if all the methods are working properly.

## New Feature: Customer Savings Tracking

The Online Store Management System includes a feature to track the total amount each customer has saved through product discounts. This feature enhances customer engagement by:

1. Automatically calculating savings for each purchase (original price - discounted price)
2. Keeping a running total of all savings for each customer
3. Displaying savings information when printing customer details

This feature helps customers understand the value they're getting from the store's discount programs and allows the store to highlight customer savings as a marketing tool. Store managers can use this information to create targeted promotions and incentives for customers who haven't taken advantage of available discounts.

## Future Improvements

The example above is very basic for the OSMS. It can be improved by adding convenient features. Let's define some of them:

1. Add the ability to categorize products properly with a category field rather than relying on name matching.
2. Implement inventory tracking to monitor stock levels for each product.
3. Add support for different payment methods.
4. Introduce a loyalty program that awards points based on purchase amounts.
5. Implement order history tracking with order dates and status updates.
6. Add shopping cart functionality for customers to add multiple items before checkout.
7. Implement user authentication and password management for customers.
8. Add reporting features to analyze sales trends and popular products.
