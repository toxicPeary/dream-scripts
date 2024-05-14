package value;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.wrappers.interactive.Player;

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
    public static boolean animating() {
        return Players.getLocal().isAnimating();
    }
    public static boolean moving() {
        return Players.getLocal().isMoving();
    }
    public static Player localPlayer() {
        return Players.getLocal();
    }
    public static final NPC combatInstructor() {
        return NPCs.closest("Combat Instructor");
    }
}
