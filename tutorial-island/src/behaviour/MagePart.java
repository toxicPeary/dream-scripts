package behaviour;


import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;

import static value.Constants.timer;
import static value.Sleep.*;
import static value.WidgetLib.*;

public class MagePart extends TaskNode {


    @Override
    public boolean accept() {
        Area mageArea = new Area(
                new Tile[] {
                        new Tile(3114, 3105, 0),
                        new Tile(3120, 3105, 0),
                        new Tile(3120, 3103, 0),
                        new Tile(3139, 3103, 0),
                        new Tile(3141, 3105, 0),
                        new Tile(3151, 3105, 0),
                        new Tile(3151, 3103, 0),
                        new Tile(3151, 3075, 0),
                        new Tile(3145, 3073, 0),
                        new Tile(3127, 3069, 0),
                        new Tile(3106, 3082, 0),
                        new Tile(3108, 3094, 0),
                        new Tile(3108, 3100, 0),
                        new Tile(3107, 3101, 0),
                        new Tile(3107, 3102, 0),
                        new Tile(3111, 3106, 0),
                        new Tile(3114, 3106, 0)
                }
        );;
        return mageArea.contains(localPlayer());
    }

    @Override
    public int execute() {
        Logger.info("executing Mage Part");

        //check for different dialogue and press on the correct one in either one of the scenarios

        if (Widgets.get(219, 1, 1) != null && Widgets.get(219, 1, 1).isVisible() && Widgets.get(219, 1, 1).getText().contains("Yes, send me to the mainland") && !animating() && !moving()) {
            Widgets.get(219, 1, 1).interact();
            return sleepLong();
        } else if (Widgets.get(219, 1, 2) != null && Widgets.get(219, 1, 2).isVisible() && Widgets.get(219, 1, 2).getText().contains("Yes, send me to the mainland") && !animating() && !moving()) {
            Widgets.get(219, 1, 2).interact();
            return sleepLong();
        } else if (Widgets.get(219, 1, 3) != null && Widgets.get(219, 1, 3).isVisible() && Widgets.get(219, 1, 3).getText().contains("Yes, send me to the mainland") && !animating() && !moving()) {
            Widgets.get(219, 1, 3).interact();
            return sleepLong();
        }


        if (Widgets.get(219, 1, 1) != null && Widgets.get(219, 1, 1).isVisible() && Widgets.get(219, 1, 1).getText().contains("No,") && !animating() && !moving()) {
            Widgets.get(219, 1, 1).interact();
            return sleepLong();
        } else if (Widgets.get(219, 1, 2) != null && Widgets.get(219, 1, 2).isVisible() && Widgets.get(219, 1, 2).getText().contains("No,") && !animating() && !moving()) {
            Widgets.get(219, 1, 2).interact();
            return sleepLong();
        } else if (Widgets.get(219, 1, 3) != null && Widgets.get(219, 1, 3).isVisible() && Widgets.get(219, 1, 3).getText().contains("No,") && !animating() && !moving()) {
            Widgets.get(219, 1, 3).interact();
            return sleepLong();
        }


        if (Widgets.get(219, 1, 1) != null && Widgets.get(219, 1, 1).isVisible() && Widgets.get(219, 1, 1).getText().contains("Yes.") && !animating() && !moving()) {
            Widgets.get(219, 1, 1).interact();
            return sleepLong();
        } else if (Widgets.get(219, 1, 2) != null && Widgets.get(219, 1, 2).isVisible() && Widgets.get(219, 1, 2).getText().contains("Yes.") && !animating() && !moving()) {
            Widgets.get(219, 1, 2).interact();
            return sleepLong();
        }

        if (textboxWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("You're nearly finished") && !animating() && !moving()) {
            NPCs.closest("Magic Instructor").interact("Talk-to");
            return sleepLong();
        }

        if (Widgets.get(218, 8) != null && textboxWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("You now have some runes.") && !animating() && !moving()) {
            Widgets.get(218, 8).interact("Cast");
            sleep(sleepLong());
            NPCs.closest("Chicken").interact("Cast");
            return sleepLong();
        }

        if (textboxWidget() != null &&textboxWidget().isVisible() && textboxWidget().getText().contains("This is your magic interface.") && !animating() && !moving()) {
            NPCs.closest("Magic Instructor").interact("Talk-to");
            return sleepLong();
        }

        if (magicWidget() != null && textboxWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Open up the magic interface") && !animating() && !moving()) {
            magicWidget().interact();
            return sleepLong();
        }

        if (textboxWidget() != null &&textboxWidget().isVisible() && textboxWidget().getText().contains("Follow the path to the")  && !animating()) {
            if (!new Area(3137, 3091, 3141, 3082).contains(localPlayer())) {
                Walking.walk(new Area(3137, 3091, 3141, 3082).getRandomTile());
                return sleepLong();
            } else {
                NPCs.closest("Magic Instructor").interact("Talk-to");
            }
            return sleepLong();
        }

        if (continueWidget229() != null && continueWidget229().isVisible() && !animating() && !moving()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget231() != null && continueWidget231().isVisible() && !animating() && !moving()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget193() != null && continueWidget193().isVisible() && !animating() && !moving()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget217() != null && continueWidget217().isVisible() && !animating() && !moving()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget11() != null && continueWidget11().isVisible() && !animating() && !moving()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget162() != null && continueWidget162().isVisible() && !animating() && !moving()) {
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }


        return sleepMedium();
    }
}