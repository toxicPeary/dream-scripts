package behaviour;


import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;

import static value.Constants.combatArea;
import static value.Constants.combatTut;
import static value.Sleep.*;
import static value.WidgetLib.*;

public class CombatPart extends TaskNode {


    @Override
    public boolean accept() {

        return combatArea.contains(localPlayer());
    }

    @Override
    public int execute() {
        Logger.info("executing combat Part");


        if (textboxWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Moving on") && !moving() && !animating()) {
            GameObjects.closest("Ladder").interact("Climb-up");
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Now you have a bow") && !moving() && !animating()) {
            Inventory.interact("Shortbow", "Wield");
            sleep(sleepLong());
            Inventory.interact("Bronze arrow", "Wield");
            sleep(sleepLong());
            NPCs.closest("Giant rat").interact("Attack");
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Pass through the gate") &&  !moving() && !animating() ) {
            GameObjects.closest("Gate").interact();
            sleep(Calculations.random(5000, 7000));
            combatInstructor().interact("Talk-to");
            return Calculations.random(3000, 5000);
        }


        if (textboxWidget().isVisible() && (textboxWidget().getText().contains("It's time to slay some rats!") || textboxWidget().getText().contains("Sit back and watch")) && !moving() && !animating()) {
            NPCs.closest("Giant rat").interact("Attack");
            return sleepMedium();
        }

        if (textboxWidget().isVisible()
                && textboxWidget().getText().contains("This is your combat interface.")
                && !moving()
                && !animating()
                && !new Area(3113, 9520, 3111, 9516).contains(localPlayer())) {
            Walking.walk(new Area(3113, 9520, 3111, 9516).getRandomTile());
            return sleepMedium();
        }
        if(textboxWidget().isVisible()
                && textboxWidget().getText().contains("This is your combat interface.")
                && !moving()
                && !animating()
                && new Area(3113, 9520, 3111, 9516).contains(localPlayer())) {
            GameObjects.closest("Gate").interact("Open");
            return sleepLong();
        }

        if (Widgets.get(548, 63) != null && textboxWidget().isVisible() && textboxWidget().getText().contains("open the combat interface") && !animating() && !moving()) {
            Widgets.get(548, 63).interact();
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("To unequip an item,") && !animating() && !moving()) {
            Inventory.interact("Bronze sword", "Wield");
            sleep(sleepLong());
            Inventory.interact("Wooden shield", "Wield");
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("You're now holding your dagger.") && !animating() && !moving()) {
            combatInstructor().interact("Talk-to");
            return sleepLong();
        }
        if (textboxWidget().isVisible() && textboxWidget().getText().contains("You can see what items you are wearing") && !animating() && !moving()) {
            Inventory.interact("Bronze dagger", "Equip");
            return sleepLong();
        }

        if (equipmentStatsWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("This is your worn inventory.") && !animating() && !moving()) {
            equipmentStatsWidget().interact();
            return sleepLong();
        }

        if (equipmentWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("You now have access to a new interface") && !animating() && !moving()) {
            equipmentWidget().interact("Worn Equipment");
            return sleepLong();
        }
       if (textboxWidget().isVisible() && textboxWidget().getText().contains("In this area you will find out about melee") && !animating() && !moving()) {
           if (!combatTut.contains(localPlayer())){
               Walking.walk(combatTut.getRandomTile());
           } else {
            combatInstructor().interact("Talk-to");
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