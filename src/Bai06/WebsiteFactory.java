package Bai06;

public class WebsiteFactory implements SalesChannelFactory {
    @Override
    public String getCode() {
        return "1";
    }

    @Override
    public String getName() {
        return "Website";
    }

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new WebsiteDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new EmailNotification();
    }
}

