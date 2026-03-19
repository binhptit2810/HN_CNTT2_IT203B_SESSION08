package Bai06;

import java.util.Locale;

public class CashPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.printf(Locale.US, "Thanh toán tiền mặt tại kiosk: %,.0f%n", amount);
        return true;
    }

    @Override
    public String getName() {
        return "Thanh toán tiền mặt";
    }
}

