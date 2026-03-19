package Bai01;

public class HardwareConnection {
    private static HardwareConnection instance;
    
    // Private constructor to prevent instantiation
    private HardwareConnection() {
    }
    
    // Synchronized method to get singleton instance
    public static synchronized HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
            instance.connect();
        }
        return instance;
    }
    
    public void connect() {
        System.out.println("HardwareConnection: Đã kết nối phần cứng.");
    }
    
    public void disconnect() {
        System.out.println("HardwareConnection: Đã ngắt kết nối phần cứng.");
    }
}

