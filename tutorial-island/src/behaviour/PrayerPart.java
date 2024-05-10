package behaviour;


import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.interactive.GameObject;

import static value.Constants.*;
import static value.Sleep.*;
import static value.WidgetLib.*;

public class PrayerPart extends TaskNode {


    @Override
    public boolean accept() {

        return prayerArea.contains(localPlayer());
    }

    @Override
    public int execute() {
        Logger.info("executing Prayer Part");


        if (textboxWidget().isVisible() && textboxWidget().getText().contains("You're almost finished") && !animating() && !moving()) {
            GameObjects.closest("Door").interact("Open");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("These two lists") && !animating() && !moving()) {
            NPCs.closest("Brother Brace").interact("Talk-to");
            return sleepLong();
        }

        if (friendsWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("You should now see") && !animating() && !moving()) {
            friendsWidget().interact();
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Talk with Brother Brace") && !animating() && !moving()) {
            NPCs.closest("Brother Brace").interact("Talk-to");
            return sleepLong();
        }

        if (prayerWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Click on the flashing icon") && !animating() && !moving()) {
            prayerWidget().interact();
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Follow the path to the chapel") && !animating()) {
            if (!new Area(3120, 3110, 3128, 3103).contains(localPlayer())) {
                Walking.walk(new Area(3120, 3110, 3128, 3103).getRandomTile());
            } else {
                NPCs.closest("Brother Brace").interact("Talk-to");
            }
            return sleepLong();
        }

        if (continueWidget231() != null && continueWidget231().isVisible()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget217() != null && continueWidget217().isVisible()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget11() != null && continueWidget11().isVisible()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget229() != null && continueWidget229().isVisible()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget193() != null && continueWidget193().isVisible()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }


        return sleepMedium();
    }
}