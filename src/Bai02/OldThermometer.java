package Bai02;

import java.util.Random;

public class OldThermometer {
    private final Random random = new Random();
    public int getTemperatureFahrenheit() {
        return 75 + random.nextInt(6); // 75..80 F
    }
}

