package Bai06;

import java.util.Locale;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.printf(Locale.US, "Xử lý thanh toán thẻ tín dụng: %,.0f%n", amount);
        return true;
    }

    @Override
    public String getName() {
        return "Thanh toán thẻ tín dụng";
    }
}

