package Bai03;

public class AirConditioner {
    private int temperature = 25;

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temp + "°C");
    }

    public int getTemperature() {
        return temperature;
    }
}

