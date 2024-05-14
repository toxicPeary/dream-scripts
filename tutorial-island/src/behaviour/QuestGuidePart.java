package behaviour;


import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;

import static value.Constants.insideQuest;
import static value.Constants.*;
import static value.Sleep.*;
import static value.WidgetLib.*;

public class QuestGuidePart extends TaskNode {


    @Override
    public boolean accept() {

        return outsideQuest.contains(localPlayer()) || insideQuest.contains(localPlayer());
    }

    @Override
    public int execute() {
        Logger.info("executing Quest Part");
        if (textboxWidget().isVisible()
        && textboxWidget().getText().contains("Moving on") && !animating() && !moving()) {
            GameObjects.closest("Ladder").interact();
            return sleepMedium();
        }
        if (textboxWidget().isVisible()
                && textboxWidget().getText().contains("This is your quest journal.") && !animating() && !moving()){
            NPCs.closest("Quest Guide").interact("Talk-to");
            return sleepMedium();
        }
        if (textboxWidget().isVisible()
                && textboxWidget().getText().contains("Quest journal") && !animating() && !moving()) {
            questWidget().interact();
            return sleepMedium();
        }
        if (textboxWidget().getText().contains("Quests") && textboxWidget().isVisible() && !animating() && !moving()) {
            NPCs.closest("Quest Guide").interact("Talk-to");
            return sleepMedium();
        }
        if (new Area(3084, 3128, 3087, 3126).contains(localPlayer()) && !animating() && !moving()) {
            GameObjects.closest("Door").interact();
            return sleepMedium();
        }
        if (outsideQuest.contains(localPlayer())) {
            Walking.walk(new Area(3084, 3128, 3087, 3126).getRandomTile());
            return sleepMedium();
        }
        if (continueWidget193() != null && continueWidget193().isVisible() && !animating() && !moving()) {
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget231() != null && continueWidget231().isVisible() && !animating() && !moving()) {
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget217() != null && continueWidget217().isVisible() && !animating() && !moving()) {
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }
        if (continueWidget11() != null && continueWidget11().isVisible() && !animating() && !moving()) {
            Keyboard.typeKey(Key.SPACE);
            return sleepMedium();
        }

        return sleepMedium();
    }
}