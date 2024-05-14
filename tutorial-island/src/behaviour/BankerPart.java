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

public class BankerPart extends TaskNode {


    @Override
    public boolean accept() {
        Area bankingArea = new Area(3107, 3132, 3129, 3113);
        return bankingArea.contains(localPlayer());
    }

    @Override
    public int execute() {
        Logger.info("executing Banking Part");





        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Continue through the next door.") && !animating() && !moving()) {
            if (!new Area(3128, 3123, 3129, 3124).contains(localPlayer())) {
                Walking.walk(new Area(3128, 3123, 3129, 3124).getRandomTile());
            } else {
                GameObjects.closest("Door").interact();
            }
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("This is your Account Management") && !animating() && !moving()) {
            NPCs.closest("Account Guide").interact("Talk-to");
            return sleepMedium();
        }

        if (accountManagementWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Click on the flashing icon") && !animating() && !moving()) {
            accountManagementWidget().interact();
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("The guide here will tell you") && !animating() && !moving()) {
            NPCs.closest("Account Guide").interact("Talk-to");
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Polls are run periodically to let the") && !animating() && !moving()) {
            if (!new Area(3124, 3124, 3124, 3124).contains(localPlayer())) {
                Walking.walk(3124, 3124);
            } else {
                GameObjects.closest("Door").interact();
            }
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("This is your bank.") && !animating() && !moving()) {
            GameObjects.closest("Poll booth").interact("Use");
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Follow the path and you") && !animating() && !moving()) {
            GameObjects.closest("Bank booth").interact("Use");
            return sleepMedium();
        }

        if (continueWidget231() != null && continueWidget231().isVisible() && !animating() && !moving()) {
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
        if (continueWidget229() != null && continueWidget229().isVisible() && !animating() && !moving()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget193() != null && continueWidget193().isVisible() && !animating() && !moving()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }


        return sleepMedium();
    }
}