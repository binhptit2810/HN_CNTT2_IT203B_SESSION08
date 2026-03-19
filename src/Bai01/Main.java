package Bai01;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static HardwareConnection connection;
    private static final List<Device> devices = new ArrayList<>();
    private static final Scanner scanner;
    
    static {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    }
    
    static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    connectHardware();
                    break;
                case 2:
                    createNewDevice();
                    break;
                case 3:
                    controlDevice();
                    break;
                case 4:
                    testSingleton();
                    break;
                case 5:
                    running = false;
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
            System.out.println();
        }
    }
    
    private static void displayMenu() {
        System.out.println("MENU QUẢN LÝ THIẾT BỊ THÔNG MINH");
        System.out.println("1. Kết nối phần cứng");
        System.out.println("2. Tạo thiết bị mới");
        System.out.println("3. Điều khiển thiết bị");
        System.out.println("4. Kiểm tra Singleton");
        System.out.println("5. Thoát");
        System.out.print("Chọn: ");
    }
    private static void connectHardware() {
        connection = HardwareConnection.getInstance();
    }
    
    private static void createNewDevice() {
        System.out.println("\nTẠO THIẾT BỊ MỚI");
        System.out.println("Chọn loại thiết bị:");
        System.out.println("1. Đèn (Light)");
        System.out.println("2. Quạt (Fan)");
        System.out.println("3. Điều hòa (AirConditioner)");
        System.out.print("Chọn loại: ");
        
        int deviceType = getIntInput();
        DeviceFactory factory;
        
        switch (deviceType) {
            case 1:
                factory = new LightFactory();
                break;
            case 2:
                factory = new FanFactory();
                break;
            case 3:
                factory = new AirConditionerFactory();
                break;
            default:
                System.out.println("Loại thiết bị không hợp lệ.");
                return;
        }
        
        Device device = factory.createDevice();
        devices.add(device);
        System.out.println("Thiết bị đã được thêm vào danh sách (Tổng: " + devices.size() + " thiết bị)");
    }
    
    private static void controlDevice() {
        if (devices.isEmpty()) {
            System.out.println("Hiện tại không có thiết bị nào. Vui lòng tạo thiết bị trước.");
            return;
        }
        
        System.out.println("\n ĐIỀU KHIỂN THIẾT BỊ");
        System.out.println("Chọn thiết bị (1 - " + devices.size() + "):");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getClass().getSimpleName());
        }
        System.out.print("Chọn thiết bị: ");
        
        int deviceIndex = getIntInput() - 1;
        
        if (deviceIndex < 0 || deviceIndex >= devices.size()) {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }
        
        Device device = devices.get(deviceIndex);
        System.out.println("1. Bật thiết bị");
        System.out.println("2. Tắt thiết bị");
        System.out.print("Chọn hành động: ");
        
        int action = getIntInput();
        
        if (action == 1) {
            device.turnOn();
        } else if (action == 2) {
            device.turnOff();
        } else {
            System.out.println("Hành động không hợp lệ.");
        }
    }
    
    private static void testSingleton() {
        System.out.println("\nKIỂM TRA SINGLETON");
        HardwareConnection connection2 = HardwareConnection.getInstance();
        
        if (connection == connection2) {
            System.out.println("Xác nhận: Cùng một instance Singleton!");
            System.out.println("(Không có tin nhắn 'kết nối' mới -> Singleton hoạt động đúng)");
        } else {
            System.out.println("✗ Lỗi: Đây là những instance khác nhau!");
        }
    }
    
    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            return -1;
        }
    }
}




