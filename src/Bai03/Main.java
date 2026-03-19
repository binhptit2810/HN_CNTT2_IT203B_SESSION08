package Bai03;

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
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();
        RemoteControl remote = new RemoteControl();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    assignCommand(remote, light, fan, ac);
                    break;
                case 2:
                    pressButton(remote);
                    break;
                case 3:
                    remote.undo();
                    break;
                case 4:
                    remote.listSlots();
                    break;
                case 5:
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
        System.out.println("=== DEMO COMMAND PATTERN - REMOTE CONTROL ===");
        System.out.println("1. Gán lệnh cho nút");
        System.out.println("2. Nhấn nút");
        System.out.println("3. Undo");
        System.out.println("4. Xem nút đã gán");
        System.out.println("5. Thoát");
        System.out.print("Chọn: ");
    }

    private static void assignCommand(RemoteControl remote, Light light, Fan fan, AirConditioner ac) {
        System.out.print("Chọn số nút (1-9): ");
        int slot = readInt();
        System.out.println("Chọn lệnh:");
        System.out.println("1. Đèn Bật");
        System.out.println("2. Đèn Tắt");
        System.out.println("3. Quạt Bật");
        System.out.println("4. Quạt Tắt");
        System.out.println("5. Điều hòa đặt nhiệt độ");
        System.out.print("Chọn: ");
        int cmdType = readInt();

        Command cmd;
        switch (cmdType) {
            case 1:
                cmd = new LightOnCommand(light);
                break;
            case 2:
                cmd = new LightOffCommand(light);
                break;
            case 3:
                cmd = new FanOnCommand(fan);
                break;
            case 4:
                cmd = new FanOffCommand(fan);
                break;
            case 5:
                System.out.print("Nhập nhiệt độ muốn đặt: ");
                int temp = readInt();
                cmd = new ACSetTemperatureCommand(ac, temp);
                break;
            default:
                System.out.println("Lệnh không hợp lệ");
                return;
        }
        remote.assign(slot, cmd);
    }

    private static void pressButton(RemoteControl remote) {
        System.out.print("Nhấn số nút: ");
        int slot = readInt();
        remote.press(slot);
    }

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }
}

