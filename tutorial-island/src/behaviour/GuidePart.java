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

import static value.Constants.cookingInside;
import static value.Sleep.*;
import static value.WidgetLib.*;

public class GuidePart extends TaskNode {


    @Override
    public boolean accept() {
        Area insideGuide = new Area(3091, 3112, 3095, 3100);
        return insideGuide.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Logger.info("executing Guide Part");
        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Moving on")) {
            GameObjects.closest("Door").interact();
            return sleepLong();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("On the side panel,")) {
            NPCs.closest("Gielinor Guide").interact("Talk-to");
            return sleepMedium();
        }
//should break here
        if (Widgets.get(548, 51) != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Setti menu")) {
            Widgets.get(548, 51).interact();
            return sleepMedium();
        }

        if (Widgets.get(219, 1) != null && Widgets.get(219, 1).isVisible() && Widgets.get(219, 1, 0).getText().contains("What's your experience")) {
            Widgets.get(219, 1, Calculations.random(1, 3)).interact();
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Getting started")) {
            NPCs.closest("Gielinor Guide").interact("Talk-to");
            return sleepMedium();
        }
        if (continueWidget229() != null && continueWidget229().isVisible()) {
            Logger.info("2");
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
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

        return sleepMedium();
    }
}