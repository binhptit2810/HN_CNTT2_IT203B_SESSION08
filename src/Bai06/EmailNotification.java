package Bai06;

public class EmailNotification implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("Gửi email: " + message);
    }

    @Override
    public String getName() {
        return "Email";
    }
}

