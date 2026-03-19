package Bai02;

public class SmartHomeFacade {
    private final TemperatureSensor temperatureSensor;
    private final Light light;
    private final Fan fan;
    private final AirConditioner airConditioner;

    public SmartHomeFacade(TemperatureSensor temperatureSensor, Light light, Fan fan, AirConditioner airConditioner) {
        this.temperatureSensor = temperatureSensor;
        this.light = light;
        this.fan = fan;
        this.airConditioner = airConditioner;
    }

    public double getCurrentTemperature() {
        return temperatureSensor.getTemperatureCelsius();
    }

    public void leaveHome() {
        System.out.println("FACADE: Tắt đèn");
        light.off();
        System.out.println("FACADE: Tắt quạt");
        fan.off();
        System.out.println("FACADE: Tắt điều hòa");
        airConditioner.off();
    }

    public void sleepMode() {
        System.out.println("FACADE: Tắt đèn");
        light.off();
        System.out.println("FACADE: Điều hòa đặt 28°C");
        airConditioner.setTemperature(28);
        System.out.println("FACADE: Quạt chạy tốc độ thấp");
        fan.lowSpeed();
    }
}
