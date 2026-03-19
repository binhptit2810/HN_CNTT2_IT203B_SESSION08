package Bai06;

public class POSFactory implements SalesChannelFactory {
    @Override
    public String getCode() {
        return "3";
    }

    @Override
    public String getName() {
        return "POS";
    }

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CodPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PrintReceiptNotification();
    }
}

