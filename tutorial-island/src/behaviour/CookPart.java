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

import static value.Constants.cookingInside;
import static value.Constants.firstCookDoor;
import static value.Sleep.*;
import static value.WidgetLib.*;

public class CookPart extends TaskNode {


    @Override
    public boolean accept() {
        Area cookingArea = new Area(
                new Tile[] {
                        new Tile(3076, 3098, 0),
                        new Tile(3076, 3092, 0),
                        new Tile(3073, 3092, 0),
                        new Tile(3073, 3088, 0),
                        new Tile(3074, 3088, 0),
                        new Tile(3074, 3087, 0),
                        new Tile(3073, 3087, 0),
                        new Tile(3073, 3082, 0),
                        new Tile(3066, 3082, 0),
                        new Tile(3063, 3067, 0),
                        new Tile(3074, 3067, 0),
                        new Tile(3090, 3057, 0),
                        new Tile(3090, 3065, 0),
                        new Tile(3089, 3066, 0),
                        new Tile(3089, 3069, 0),
                        new Tile(3090, 3070, 0),
                        new Tile(3090, 3077, 0),
                        new Tile(3092, 3079, 0),
                        new Tile(3092, 3082, 0),
                        new Tile(3091, 3083, 0),
                        new Tile(3091, 3084, 0),
                        new Tile(3090, 3085, 0),
                        new Tile(3090, 3087, 0),
                        new Tile(3089, 3088, 0),
                        new Tile(3089, 3090, 0),
                        new Tile(3090, 3091, 0),
                        new Tile(3090, 3094, 0),
                        new Tile(3088, 3096, 0),
                        new Tile(3087, 3096, 0),
                        new Tile(3086, 3097, 0),
                        new Tile(3085, 3097, 0),
                        new Tile(3083, 3099, 0),
                        new Tile(3082, 3098, 0)
                }
        );
        return cookingArea.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Logger.info("executing Cook Part");
        if (textboxWidget().getText().contains("Moving on") && textboxWidget().isVisible() && !animating() && !moving() && new Area(3074, 3089, 3074, 3089).contains(localPlayer())) {
            GameObjects.closest("Door").interact();
            return sleepLong();
        }
        if (textboxWidget().getText().contains("Moving on") && textboxWidget().isVisible() && !animating() && !moving() && !new Area(3074, 3089, 3074, 3089).contains(localPlayer())) {
            Walking.walk(new Area(3074, 3089, 3074, 3089));
            return sleepLong();
        }
        if (Inventory.contains("Bread dough") && !animating() && !moving()) {
            Inventory.interact("Bread dough");
            sleep(sleepLong());
            GameObjects.closest("Range").interact();
            return sleepMedium();
        }
        if (Inventory.contains("Pot of flour", "Bucket of water") && !animating() && !moving()) {
            Inventory.interact("Pot of flour");
            sleep(sleepShort());
            Inventory.interact("Bucket of water");
            return sleepLong();
        }
        if (cookingInside.contains(localPlayer()) && textboxWidget().getText().contains("Cooking") && textboxWidget().isVisible() && !animating() && !moving()) {
            NPCs.closest("Master Chef").interact("Talk-to");
            return sleepMedium();
        }
        if (GameObjects.closest("Door") != null
                && !cookingInside.contains(Players.getLocal())
                && !animating()
                && !moving()
                && firstCookDoor.contains(localPlayer())) {
            GameObjects.closest("Door").interact();
            return sleepMedium();
        }
        if (GameObjects.closest("Door") != null
                && !cookingInside.contains(Players.getLocal())
                && !animating()
                && !moving()
                && !firstCookDoor.contains(localPlayer())){
            Walking.walk(firstCookDoor.getRandomTile());
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