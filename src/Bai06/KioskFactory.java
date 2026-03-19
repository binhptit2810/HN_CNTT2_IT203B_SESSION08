package Bai06;

public class KioskFactory implements SalesChannelFactory {
    @Override
    public String getCode() {
        return "4";
    }

    @Override
    public String getName() {
        return "Kiosk";
    }

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new KioskDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CashPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new SmsNotification();
    }
}

