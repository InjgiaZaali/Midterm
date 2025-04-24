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