package Bai05;

public class AirConditionerObserver implements Observer {
    private final AirConditioner ac;

    public AirConditionerObserver(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void update(int temperature) {
        // Giữ nhiệt độ đặt, nhưng thông báo điều chỉnh nếu quá nóng
        if (temperature > 30) {
            System.out.println("Điều hòa: Phát hiện nóng, duy trì " + ac.getTemperature() + "°C");
        } else {
            System.out.println("Điều hòa: Nhiệt độ ổn, giữ " + ac.getTemperature() + "°C");
        }
    }
}

