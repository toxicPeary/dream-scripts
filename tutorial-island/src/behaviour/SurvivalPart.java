package behaviour;


import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.interactive.NPC;

import static value.WidgetLib.*;
import static value.Sleep.*;
import static value.Constants.*;

public class SurvivalPart extends TaskNode {


    @Override
    public boolean accept() {
        Area survivalStart = new Area(3098, 3107, 3105, 3096);
        Area survivalGate = new Area(3090, 3099, 3105, 3090);
        return survivalStart.contains(Players.getLocal())
                || survivalGate.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        if (Widgets.get(263, 1, 0) != null
                && Widgets.get(263, 1, 0).getText().contains("Moving on")){
            GameObjects.closest("Door").interact("Open");
            sleep(sleepMedium());
            Walking.walk(new Tile(3104, 3095));
            return sleepLong();
        }
        if (settingsMenu().getTextureId() == 1181) {
            if (experienceWidget() != null) {
                Logger.info("1");
                int i = Calculations.random(1, 3);
                Widgets.get(219, 1, i).interact();
                return sleepMedium();

            } else if (continueWidget() != null) {
                Logger.info("2");
                Keyboard.typeKey(Key.SPACE);
                return sleepMedium();

            } else {
                NPCs.closest("Gielinor Guide").interact("Talk-to");
                Logger.info("3");
                return sleepMedium();

            }
        }
        if (settingsMenu().getTextureId() != 1181) {

            if (settingsMenu() != null && settingsMenu().isVisible()) {
                settingsMenu().interact();
                return sleepMedium();

            } else if (experienceWidget() != null) {
                Logger.info("1");
                int i = Calculations.random(1, 3);
                Widgets.get(219, 1, i).interact();
                return sleepMedium();

            } else if (continueWidget() != null) {
                Logger.info("2");
                Keyboard.typeKey(Key.SPACE);
                return sleepMedium();

            } else {
                NPCs.closest("Gielinor Guide").interact("Talk-to");
                Logger.info("3");
                return sleepMedium();

            }

        }
        return sleepMedium();
    }
}