package Bai06;

import java.util.Locale;

public class CodPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.printf(Locale.US, "Thanh toán COD tại cửa hàng: %,.0f%n", amount);
        return true;
    }

    @Override
    public String getName() {
        return "Thanh toán COD";
    }
}

