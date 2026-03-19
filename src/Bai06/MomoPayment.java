package Bai06;

import java.util.Locale;

public class MomoPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.printf(Locale.US, "Xử lý thanh toán MoMo: %,.0f%n", amount);
        return true;
    }

    @Override
    public String getName() {
        return "Thanh toán MoMo";
    }
}

