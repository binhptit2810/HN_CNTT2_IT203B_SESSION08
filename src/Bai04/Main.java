package Bai04;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner;

    static {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        Fan fan = new Fan();
        Humidifier humidifier = new Humidifier();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    sensor.attach(fan);
                    System.out.println("Quạt: Đã đăng ký nhận thông báo");
                    break;
                case 2:
                    sensor.attach(humidifier);
                    System.out.println("Máy tạo ẩm: Đã đăng ký");
                    break;
                case 3:
                    sensor.detach(fan);
                    System.out.println("Quạt: Đã hủy đăng ký");
                    break;
                case 4:
                    sensor.detach(humidifier);
                    System.out.println("Máy tạo ẩm: Đã hủy đăng ký");
                    break;
                case 5:
                    System.out.print("Nhập nhiệt độ mới: ");
                    int temp = readInt();
                    sensor.setTemperature(temp);
                    break;
                case 6:
                    running = false;
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("=== DEMO OBSERVER - CẢM BIẾN NHIỆT ĐỘ ===");
        System.out.println("1. Đăng ký Quạt");
        System.out.println("2. Đăng ký Máy tạo ẩm");
        System.out.println("3. Hủy đăng ký Quạt");
        System.out.println("4. Hủy đăng ký Máy tạo ẩm");
        System.out.println("5. Đặt nhiệt độ (giả lập)");
        System.out.println("6. Thoát");
        System.out.print("Chọn: ");
    }

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }
}

