package Bai06;

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
        FactoryRegistry registry = new FactoryRegistry();
        registry.register(new WebsiteFactory());
        registry.register(new MobileAppFactory());
        registry.register(new POSFactory());
        registry.register(new KioskFactory()); // minh họa mở rộng không sửa code cũ

        boolean running = true;
        while (running) {
            printMenu(registry);
            System.out.print("Chọn kênh: ");
            String choice = scanner.nextLine().trim();
            if ("0".equals(choice)) {
                running = false;
                System.out.println("Thoát chương trình");
                break;
            }
            SalesChannelFactory factory = registry.get(choice);
            if (factory == null) {
                System.out.println("Kênh không hợp lệ");
                continue;
            }
            System.out.println("Bạn đã chọn kênh " + factory.getName());
            Order order = readOrder();
            OrderService service = new OrderService(factory);
            service.processOrder(order);
            System.out.println();
        }
    }

    private static void printMenu(FactoryRegistry registry) {
        System.out.println("=== HỆ THỐNG BÁN HÀNG ĐA KÊNH (ABSTRACT FACTORY) ===");
        registry.list().forEach(f -> System.out.println(f.getCode() + ". " + f.getName()));
        System.out.println("0. Thoát");
    }

    private static Order readOrder() {
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine().trim();
        System.out.print("Nhập đơn giá (vd 15000000): ");
        double price = readDouble();
        System.out.print("Nhập số lượng: ");
        int qty = readInt();
        System.out.printf(Locale.US, "Tạo đơn: %s x%d, đơn giá %,.0f%n", name, qty, price);
        return new Order(name, price, qty);
    }

    private static double readDouble() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return 0;
        }
    }
}

