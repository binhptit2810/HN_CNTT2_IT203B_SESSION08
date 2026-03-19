package Bai05;

public class FanObserver implements Observer {
    private final Fan fan;

    public FanObserver(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            fan.high();
        } else if (temperature >= 20) {
            fan.low();
        } else {
            fan.off();
        }
    }
}

