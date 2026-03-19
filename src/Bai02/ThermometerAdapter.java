package Bai02;

public class ThermometerAdapter implements TemperatureSensor {
    private final OldThermometer legacyThermometer;

    public ThermometerAdapter(OldThermometer legacyThermometer) {
        this.legacyThermometer = legacyThermometer;
    }

    @Override
    public double getTemperatureCelsius() {
        int fahrenheit = legacyThermometer.getTemperatureFahrenheit();
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}

