package Bai05;

public class Light {
    private boolean on = true;

    public void on() {
        on = true;
        System.out.println("Đèn: Bật");
    }

    public void off() {
        on = false;
        System.out.println("Đèn: Tắt");
    }

    public boolean isOn() {
        return on;
    }
}

