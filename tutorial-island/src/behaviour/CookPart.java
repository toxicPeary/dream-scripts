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

import java.util.Objects;

import static value.WidgetLib.*;
import static value.Sleep.*;
import static value.Constants.*;

public class CookPart extends TaskNode {


    @Override
    public boolean accept() {
        Area cookingArea = new Area(
                new Tile[]{
                        new Tile(3089, 3091, 0),
                        new Tile(3089, 3093, 0),
                        new Tile(3087, 3095, 0),
                        new Tile(3082, 3097, 0),
                        new Tile(3077, 3097, 0),
                        new Tile(3077, 3091, 0),
                        new Tile(3074, 3091, 0),
                        new Tile(3074, 3089, 0),
                        new Tile(3074, 3083, 0),
                        new Tile(3082, 3073, 0),
                        new Tile(3089, 3072, 0)
                }
        );
        return cookingArea.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Logger.info("executing Cook Part");
        if (Inventory.contains("Bread") && !animating()) {
            Walking.walk(new Tile(3074, 3089));
            sleep(sleepLong());
            GameObjects.closest("Door").interact();
        }
        if (Inventory.contains("Bread dough") && !animating()) {
            Inventory.interact("Bread dough");
            sleep(sleepShort());
            GameObjects.closest("Range").interact();
            return sleepMedium();
        }
        if (Inventory.contains("Pot of flour", "Bucket of water")) {
            Inventory.interact("Pot of flour");
            sleep(sleepShort());
            Inventory.interact("Bucket of water");
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
        if (textboxWidget().getText().contains("Cooking") && textboxWidget().isVisible()) {
            NPCs.closest("Master Chef").interact("Talk-to");
            return sleepMedium();
        }
        if (GameObjects.closest("Door") != null
                && !cookingInside.contains(Players.getLocal())) {
            GameObjects.closest("Door").interact();
            return sleepMedium();
        }


        return sleepMedium();
    }
}