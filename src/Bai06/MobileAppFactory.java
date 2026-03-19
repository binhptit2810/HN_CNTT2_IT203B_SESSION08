package Bai06;

public class MobileAppFactory implements SalesChannelFactory {
    @Override
    public String getCode() {
        return "2";
    }

    @Override
    public String getName() {
        return "Mobile App";
    }

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new FirstTimeDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PushNotification();
    }
}

