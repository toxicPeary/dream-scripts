package behaviour;


import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;

import static value.Constants.closeSurvivalExpert;
import static value.Sleep.*;
import static value.WidgetLib.*;

public class SurvivalPart extends TaskNode {


    @Override
    public boolean accept() {
        Area survivalStart = new Area(
                new Tile[] {
                        new Tile(3098, 3109, 0),
                        new Tile(3101, 3109, 0),
                        new Tile(3103, 3107, 0),
                        new Tile(3103, 3105, 0),
                        new Tile(3104, 3103, 0),
                        new Tile(3104, 3101, 0),
                        new Tile(3105, 3100, 0),
                        new Tile(3106, 3100, 0),
                        new Tile(3107, 3099, 0),
                        new Tile(3107, 3094, 0),
                        new Tile(3106, 3093, 0),
                        new Tile(3106, 3092, 0),
                        new Tile(3105, 3091, 0),
                        new Tile(3105, 3090, 0),
                        new Tile(3104, 3089, 0),
                        new Tile(3103, 3088, 0),
                        new Tile(3102, 3088, 0),
                        new Tile(3101, 3087, 0),
                        new Tile(3097, 3087, 0),
                        new Tile(3096, 3088, 0),
                        new Tile(3095, 3088, 0),
                        new Tile(3094, 3089, 0),
                        new Tile(3092, 3089, 0),
                        new Tile(3090, 3091, 0),
                        new Tile(3090, 3094, 0),
                        new Tile(3088, 3096, 0),
                        new Tile(3087, 3096, 0),
                        new Tile(3086, 3097, 0),
                        new Tile(3086, 3101, 0),
                        new Tile(3091, 3101, 0),
                        new Tile(3091, 3099, 0),
                        new Tile(3096, 3099, 0),
                        new Tile(3096, 3104, 0),
                        new Tile(3098, 3106, 0)
                }
        );;
        Area survivalGate = new Area(3090, 3099, 3105, 3090);

        return survivalStart.contains(Players.getLocal())
                || survivalGate.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Logger.info("executing Survival Part");
        if (Inventory.contains("Shrimps") && GameObjects.closest("Gate") != null && !animating() && !moving()) {
            GameObjects.closest("Gate").interact();
        } else if (textboxWidget().getText().contains("Cooking")
                && textboxWidget().isVisible()  && !animating() && !moving()) {
            Inventory.interact("Raw shrimps");
            sleep(sleepShort());
            GameObjects.closest("Fire").interact();
            return sleepLong();
        }
        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Firemaking") && !animating() && !moving()) {
            Inventory.interact("Logs");
            sleep(sleepShort());
            Inventory.interact("Tinderbox");
            return sleepMedium();
        }
        if (textboxWidget().getText().contains("Woodcutting")
                && textboxWidget().isVisible()
                && !animating() && !moving()) {

            GameObjects.closest("Tree").interact();
            return sleepMedium();
        }
        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Fishing") && !Inventory.contains("Raw shrimps") && !animating() && !moving()){
            NPCs.closest("Fishing spot").interact("Net");
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("You've been given an item") && inventoryWidget() != null && !animating() && !moving()) {
            inventoryWidget().interact();
            return sleepMedium();
        }

        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Moving around") && !closeSurvivalExpert.contains(localPlayer()) && !animating() && !moving()) {
            Walking.walk(closeSurvivalExpert.getRandomTile());
            return sleepMedium();
        }
        if (textboxWidget().isVisible() && textboxWidget().getText().contains("Moving around") && closeSurvivalExpert.contains(localPlayer()) && !animating() && !moving()) {
            NPCs.closest("Survival Expert").interact("Talk-to");
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
        if (textboxWidget().getText().contains("You've gained some experience")
                && textboxWidget().isVisible() && !animating() && !moving()) {
            expWidget().interact();
            return sleepMedium();
        }
        if (textboxWidget().getText().contains("Skills and Experience")
                && textboxWidget().isVisible() && !animating() && !moving()) {
            NPCs.closest("Survival Expert").interact("Talk-to");
            return sleepMedium();
        }


        return sleepMedium();
    }
}