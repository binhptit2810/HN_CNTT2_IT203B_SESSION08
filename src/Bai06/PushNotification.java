package Bai06;

public class PushNotification implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("Gửi push notification: " + message);
    }

    @Override
    public String getName() {
        return "Push Notification";
    }
}

