package Bai06;

public interface DiscountStrategy {

    double calculateDiscount(double originalAmount);
    
    String getName();
}

