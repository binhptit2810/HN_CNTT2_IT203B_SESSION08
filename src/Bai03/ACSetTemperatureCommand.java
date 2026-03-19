package Bai03;

public class ACSetTemperatureCommand implements Command {
    private final AirConditioner ac;
    private final int newTemperature;
    private int previousTemperature;

    public ACSetTemperatureCommand(AirConditioner ac, int newTemperature) {
        this.ac = ac;
        this.newTemperature = newTemperature;
    }

    @Override
    public void execute() {
        previousTemperature = ac.getTemperature();
        ac.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        ac.setTemperature(previousTemperature);
        System.out.println("Undo: Điều hòa về " + previousTemperature + "°C");
    }
}

