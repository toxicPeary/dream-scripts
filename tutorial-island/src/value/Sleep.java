package value;

import org.dreambot.api.methods.Calculations;

public class Sleep {
    public static int sleepShort() {
        return Calculations.random(250, 750);
    }
    public static int sleepMedium() {
        return Calculations.random(250, 1250);
    }
    public static int sleepLong() {
        return Calculations.random(250, 2250);
    }
}
