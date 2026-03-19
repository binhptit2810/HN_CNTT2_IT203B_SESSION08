package Bai05;

public class AirConditioner {
    private int temperature = 26;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Điều hòa: Nhiệt độ = " + temperature + "°C");
    }

    public int getTemperature() {
        return temperature;
    }
}

