package Bai02;

public class AirConditioner {
    public void on() {
        System.out.println("Điều hòa: bật");
    }

    public void off() {
        System.out.println("Điều hòa: tắt");
    }

    public void setTemperature(int celsius) {
        System.out.println("Điều hòa: đặt nhiệt độ " + celsius + "°C");
    }
}
