package Bai06;

public class KioskDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalAmount) {
        return originalAmount * 0.12;
    }

    @Override
    public String getName() {
        return "Giảm giá Kiosk 12%";
    }
}

