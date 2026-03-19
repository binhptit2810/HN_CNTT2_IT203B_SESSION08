package Bai06;

public class MemberDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalAmount) {
        return originalAmount * 0.05;
    }

    @Override
    public String getName() {
        return "Giảm giá thành viên 5%";
    }
}

