package Bai06;

public class PrintReceiptNotification implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("In hóa đơn: " + message);
    }

    @Override
    public String getName() {
        return "In hóa đơn";
    }
}

