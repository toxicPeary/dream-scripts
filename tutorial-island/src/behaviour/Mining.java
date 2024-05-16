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

import static value.Constants.miningArea;
import static value.Sleep.*;
import static value.WidgetLib.*;

public class Mining extends TaskNode {


    @Override
    public boolean accept() {
        Area mining = new Area(3094, 9491, 3070, 9532);
        return mining.contains(localPlayer());


    }

    @Override
    public int execute() {
        Logger.info("executing Input Mining Part");

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Moving on")  && !animating() && !moving()){
            GameObjects.closest("Gate").interact("Open");
            return sleepLong();
        }

        if (Widgets.get(312, 9) != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Now you have the smithing menu open")  && !animating() && !moving()) {
            Widgets.get(312, 9).interact("Smith");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("To smith") || textboxWidget().getText().contains("the dagger")  && !animating() && !moving()) {
            GameObjects.closest("Anvil").interact("Smith");

            return Calculations.random(8000,13000);
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("You've made a bronze bar!")  && !animating() && !moving()){
            NPCs.closest("Mining Instructor").interact("Talk-to");
            return sleepLong();
        }
//this will break here
        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Smelt")  && !animating() && !moving()){
            GameObjects.closest("Furnace").interact("use");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Now that you have some tin ore,")  && !animating() && !moving()){
            GameObjects.closest("Copper rocks").interact("Mine");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("It's quite simple really.")  && !animating() && !moving()){
            GameObjects.closest("Tin rocks").interact("Mine");
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Mining and Smithing") && !animating() && !moving()) {
            if (!miningArea.contains(localPlayer())) {
                Walking.walk(miningArea.getRandomTile());
            }
            if (NPCs.closest("Mining Instructor") != null && !animating() && !moving()) {
                NPCs.closest("Mining Instructor").interact("Talk-to");
                return sleepMedium();
            }
            return sleepMedium();
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

        return Calculations.random(250, 1250);
    }
}
