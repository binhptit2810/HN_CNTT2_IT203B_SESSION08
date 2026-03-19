package Bai06;

public class Order {
    private final String productName;
    private final double unitPrice;
    private final int quantity;

    public Order(String productName, double unitPrice, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return unitPrice * quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}

