package Bai05;

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
        Light light = new Light();
        AirConditioner ac = new AirConditioner();
        Fan fan = new Fan();
        RemoteControl remote = new RemoteControl();
        SleepModeCommand sleepCmd = new SleepModeCommand(light, ac, fan);
        remote.setSleepCommand(sleepCmd);

        TemperatureSensor sensor = new TemperatureSensor();
        FanObserver fanObserver = new FanObserver(fan);
        AirConditionerObserver acObserver = new AirConditionerObserver(ac);

        boolean observersAttached = false;
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    remote.pressSleep();
                    if (!observersAttached) {
                        sensor.attach(fanObserver);
                        sensor.attach(acObserver);
                        observersAttached = true;
                    }
                    break;
                case 2:
                    System.out.print("Nhập nhiệt độ mới: ");
                    int temp = readInt();
                    sensor.setTemperature(temp);
                    break;
                case 3:
                    printStatus(light, ac, fan, sensor);
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
        System.out.println("=== KỊCH BẢN NGỦ THÔNG MINH (COMMAND + OBSERVER) ===");
        System.out.println("1. Kích hoạt chế độ ngủ");
        System.out.println("2. Thay đổi nhiệt độ (giả lập)");
        System.out.println("3. Xem trạng thái thiết bị");
        System.out.println("4. Thoát");
        System.out.print("Chọn: ");
    }

    private static void printStatus(Light light, AirConditioner ac, Fan fan, TemperatureSensor sensor) {
        System.out.println("--- TRẠNG THÁI HIỆN TẠI ---");
        System.out.println("Đèn: " + (light.isOn() ? "Bật" : "Tắt"));
        System.out.println("Điều hòa: " + ac.getTemperature() + "°C");
        System.out.println("Quạt: " + fan.getSpeed());
        System.out.println("Nhiệt độ cảm biến: " + sensor.getTemperature());
    }

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }
}

