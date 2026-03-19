package Bai02;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
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
        TemperatureSensor sensor = new ThermometerAdapter(new OldThermometer());
        SmartHomeFacade facade = new SmartHomeFacade(sensor, new Light(), new Fan(), new AirConditioner());

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    double temp = facade.getCurrentTemperature();
                    System.out.printf(Locale.US, "Nhiệt độ hiện tại: %.1f°C%n", temp);
                    break;
                case 2:
                    facade.leaveHome();
                    break;
                case 3:
                    facade.sleepMode();
                    break;
                case 4:
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
        System.out.println("=== DEMO ADAPTER & FACADE NHÀ THÔNG MINH ===");
        System.out.println("1. Xem nhiệt độ hiện tại");
        System.out.println("2. Chế độ rời nhà");
        System.out.println("3. Chế độ ngủ");
        System.out.println("4. Thoát");
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
