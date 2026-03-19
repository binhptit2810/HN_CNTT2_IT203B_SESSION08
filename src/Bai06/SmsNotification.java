package Bai06;

public class SmsNotification implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("Gửi SMS: " + message);
    }

    @Override
    public String getName() {
        return "SMS";
    }
}

