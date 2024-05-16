package behaviour;


import org.dreambot.api.ClientSettings;
import org.dreambot.api.data.ClientLayout;
import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;

import static value.Sleep.*;
import static value.WidgetLib.*;

public class GuidePart extends TaskNode {


    @Override
    public boolean accept() {
        Area insideGuide = new Area(3091, 3110, 3097, 3103);
        return insideGuide.contains(Players.getLocal());
    }

    @Override
    public int execute() {




        Logger.info("executing Guide Part");
        if (textboxWidget() != null && textboxWidget().isVisible()
                && textboxWidget().getText().contains("Moving on")
                && !animating()
                && !moving()
                && ClientSettings.areRoofsHidden()
                && ClientSettings.getClientLayout() == ClientLayout.FIXED_CLASSIC) {
            GameObjects.closest("Door").interact();
            return sleepLong();
        }
        if (textboxWidget() != null && textboxWidget().isVisible()
                && textboxWidget().getText().contains("Moving on")
                && !animating()
                && !moving()
                && !ClientSettings.areRoofsHidden()) {
            ClientSettings.toggleRoofs(false);
        }
        if (textboxWidget() != null && textboxWidget().isVisible()
                && textboxWidget().getText().contains("Moving on")
                && !animating()
                && !moving()
                && ClientSettings.getClientLayout() != ClientLayout.FIXED_CLASSIC) {
            ClientSettings.setClientLayout(ClientLayout.FIXED_CLASSIC);
        }

        if (textboxWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("On the side panel,") && !animating() && !moving()) {
            NPCs.closest("Gielinor Guide").interact("Talk-to");
            return sleepMedium();
        }

        if (textboxWidget() != null && Widgets.get(548, 51) != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Please click on") && !animating() && !moving()) {
            Widgets.get(548, 51).interact();
            return sleepMedium();
        }

        if (Widgets.get(219, 1) != null && Widgets.get(219, 1).isVisible() && Widgets.get(219, 1, 0).getText().contains("What's your experience") && !animating() && !moving()) {
            Widgets.get(219, 1, Calculations.random(1, 3)).interact();
            return sleepMedium();
        }

        if (textboxWidget() != null && textboxWidget().isVisible() && textboxWidget().getText().contains("Getting started") && !animating() && !moving()) {
            NPCs.closest("Gielinor Guide").interact("Talk-to");
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

        return sleepMedium();
    }

}