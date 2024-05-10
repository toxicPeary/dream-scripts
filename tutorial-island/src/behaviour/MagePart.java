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

public class MagePart extends TaskNode {


    @Override
    public boolean accept() {
        Area mageArea = new Area(3114, 3102, 3144, 3076);
        return mageArea.contains(localPlayer());
    }

    @Override
    public int execute() {
        Logger.info("executing Mage Part");

        if (Widgets.get(219, 1, 1) != null && Widgets.get(219, 1, 1).isVisible() && Widgets.get(219, 1, 1).getText().contains("Yes,") && !animating() && !moving()) {
            Widgets.get(219, 1, 1).interact();
            return sleepLong();
        }


        if (Widgets.get(219, 1, 1) != null && Widgets.get(219, 1, 1).isVisible() && Widgets.get(219, 1, 1).getText().contains("Yes.") && !animating() && !moving()) {
            Widgets.get(219, 1, 1).interact();
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("You're nearly finished") && !animating() && !moving()) {
            NPCs.closest("Magic Instructor").interact("Talk-to");
            return sleepLong();
        }

        if (Widgets.get(218, 8) != null && textboxWidget().isVisible() && textboxWidget().getText().contains("You now have some runes.") && !animating() && !moving()) {
            Widgets.get(218, 8).interact("Cast");
            sleep(sleepLong());
            NPCs.closest("Chicken").interact("Cast");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("This is your magic interface.") && !animating() && !moving()) {
            NPCs.closest("Magic Instructor").interact("Talk-to");
            return sleepLong();
        }

        if (magicWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Open up the magic interface") && !animating() && !moving()) {
            magicWidget().interact();
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Follow the path to the") && !animating()) {
            if (!new Area(3137, 3091, 3141, 3082).contains(localPlayer())) {
                Walking.walk(new Area(3137, 3091, 3141, 3082).getRandomTile());
            } else {
                NPCs.closest("Magic Instructor").interact("Talk-to");
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