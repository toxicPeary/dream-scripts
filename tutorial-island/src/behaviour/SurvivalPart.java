package behaviour;


import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;

import static value.Sleep.*;
import static value.WidgetLib.*;
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
        Logger.info("executing Survival Part");
        if (Inventory.contains("Shrimps") && !animating()
                && GameObjects.closest("Gate") != null) {
            GameObjects.closest("Gate").interact();
        } else if (textboxWidget().getText().contains("Cooking")
                && textboxWidget().isVisible() && !animating()) {
            Inventory.interact("Raw shrimps");
            sleep(sleepShort());
            GameObjects.closest("Fire").interact();
            return sleepMedium();
        }
        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Firemaking")) {
            Inventory.interact("Logs");
            sleep(sleepShort());
            Inventory.interact("Tinderbox");
            return sleepMedium();
        }
        if (textboxWidget().getText().contains("Woodcutting")
                && textboxWidget().isVisible()
                && !animating()) {

            GameObjects.closest("Tree").interact();
            return sleepMedium();
        }
        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Fishing") && !animating() && !Inventory.contains("Raw shrimps")){
            NPCs.closest("Fishing spot").interact("Net");
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("You've been given an item") && inventoryWidget() != null) {
            inventoryWidget().interact();
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Moving around") && !closeSurvivalExpert.contains(localPlayer())) {
            Walking.walk(closeSurvivalExpert.getRandomTile());
            sleep(sleepMedium());
            if (!animating()) {
                NPCs.closest("Survival Expert").interact("Talk-to");
                return sleepMedium();
            }
            return sleepMedium();
        }

        if (continueWidget193() != null && continueWidget193().isVisible()) {
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget231() != null && continueWidget231().isVisible()) {
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget217() != null && continueWidget217().isVisible()) {
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget11() != null && continueWidget11().isVisible()) {
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (textboxWidget().getText().contains("You've gained some experience")
                && textboxWidget().isVisible()) {
            expWidget().interact();
            return sleepMedium();
        }
        if (textboxWidget().getText().contains("Skills and Experience")
                && textboxWidget().isVisible()) {
            NPCs.closest("Survival Expert").interact("Talk-to");
            return sleepMedium();
        }


        return sleepMedium();
    }
}