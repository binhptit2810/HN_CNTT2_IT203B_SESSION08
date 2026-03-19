package Bai06;

public interface SalesChannelFactory {
    String getCode();
    String getName();
    DiscountStrategy createDiscountStrategy();
    PaymentMethod createPaymentMethod();
    NotificationService createNotificationService();
}

