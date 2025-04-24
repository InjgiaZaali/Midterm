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

