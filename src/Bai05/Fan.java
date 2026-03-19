package Bai05;

public class Fan {
    public enum Speed {OFF, LOW, HIGH}

    private Speed speed = Speed.OFF;

    public void low() {
        speed = Speed.LOW;
        System.out.println("Quạt: Chạy tốc độ thấp");
    }

    public void high() {
        speed = Speed.HIGH;
        System.out.println("Quạt: Chạy tốc độ mạnh");
    }

    public void off() {
        speed = Speed.OFF;
        System.out.println("Quạt: Tắt");
    }

    public Speed getSpeed() {
        return speed;
    }
}

