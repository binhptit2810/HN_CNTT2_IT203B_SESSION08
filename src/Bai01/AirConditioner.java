package Bai01;

/**
 * AirConditioner - Thiết bị điều hòa
 */
public class AirConditioner implements Device {
    @Override
    public void turnOn() {
        System.out.println("Điều hòa: Phun gió lạnh.");
    }
    
    @Override
    public void turnOff() {
        System.out.println("Điều hòa: Dừng phun gió.");
    }
}

