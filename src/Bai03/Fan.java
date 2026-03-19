package Bai03;

public class Fan {
    private boolean running = false;

    public void on() {
        running = true;
        System.out.println("Quạt: Bật");
    }

    public void off() {
        running = false;
        System.out.println("Quạt: Tắt");
    }

    public boolean isRunning() {
        return running;
    }
}

