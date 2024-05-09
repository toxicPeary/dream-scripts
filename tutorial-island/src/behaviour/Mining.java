package behaviour;

import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import static value.Sleep.*;
import static value.WidgetLib.*;
import static value.Constants.*;

public class Mining extends TaskNode {


    @Override
    public boolean accept() {
        Area mining = new Area(3094, 9491, 3070, 9532);
        return mining.contains(localPlayer());


    }

    @Override
    public int execute() {
        Logger.info("executing Input Mining Part");

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Moving on") && !animating()){
            GameObjects.closest("Gate").interact("Open");
            return sleepLong();
        }

        if (Widgets.get(312, 9) != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Now you have the smithing menu open") && !animating()) {
            Widgets.get(312, 9).interact("Smith");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Use an anvil to open") && !animating()) {
            GameObjects.closest("Anvil").interact("Smith");

            return Calculations.random(8000,13000);
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("You've made a bronze bar!") && !animating()){
            NPCs.closest("Mining Instructor").interact("Talk-to");
            return sleepLong();
        }
//this will break here
        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Smelt") && !animating()){
            GameObjects.closest("Furnace").interact("use");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Now that you have some tin ore,") && !animating()){
            GameObjects.closest("Copper rocks").interact("Mine");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("It's quite simple really.") && !animating()){
            GameObjects.closest("Tin rocks").interact("Mine");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Mining and Smithing")) {
            if (!miningArea.contains(localPlayer())) {
                Walking.walk(miningArea.getRandomTile());
            }
            if (NPCs.closest("Mining Instructor") != null) {
                NPCs.closest("Mining Instructor").interact("Talk-to");
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

        return Calculations.random(250, 1250);
    }
}
