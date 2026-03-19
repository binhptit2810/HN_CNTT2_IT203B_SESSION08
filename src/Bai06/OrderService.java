package Bai06;

import java.util.Locale;

public class OrderService {
    private final SalesChannelFactory factory;

    public OrderService(SalesChannelFactory factory) {
        this.factory = factory;
    }

    public void processOrder(Order order) {
        DiscountStrategy discountStrategy = factory.createDiscountStrategy();
        PaymentMethod paymentMethod = factory.createPaymentMethod();
        NotificationService notificationService = factory.createNotificationService();

        double subtotal = order.getSubtotal();
        double discount = discountStrategy.calculateDiscount(subtotal);
        double total = subtotal - discount;

        System.out.printf(Locale.US, "Áp dụng %s: -%,.0f%n", discountStrategy.getName(), discount);
        System.out.printf(Locale.US, "Tổng thanh toán: %,.0f%n", total);

        boolean paid = paymentMethod.pay(total);
        if (paid) {
            notificationService.notifyUser("Đơn hàng thành công cho sản phẩm " + order.getProductName());
        } else {
            notificationService.notifyUser("Thanh toán thất bại cho đơn hàng " + order.getProductName());
        }
    }
}

