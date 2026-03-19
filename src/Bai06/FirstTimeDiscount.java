package Bai06;

public class FirstTimeDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalAmount) {
        return originalAmount * 0.15;
    }

    @Override
    public String getName() {
        return "Giảm giá lần đầu 15%";
    }
}

