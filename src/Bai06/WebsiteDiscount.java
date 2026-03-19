package Bai06;

public class WebsiteDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalAmount) {
        return originalAmount * 0.10;
    }

    @Override
    public String getName() {
        return "Giảm giá Website 10%";
    }
}

