package behaviour;


import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import static value.Constants.insideQuest;
import static value.Constants.outsideQuest;
import static value.Sleep.localPlayer;
import static value.Sleep.sleepMedium;
import static value.WidgetLib.*;

public class GuidePart extends TaskNode {


    @Override
    public boolean accept() {

        return outsideQuest.contains(Players.getLocal())
                || insideQuest.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Logger.info("executing Quest Part");
        if (textboxWidget().isVisible()
        && textboxWidget().getText().contains("Moving on")) {
            GameObjects.closest("Ladder").interact();
            return sleepMedium();
        }
        if (textboxWidget().isVisible()
                && textboxWidget().getText().contains("This is your quest journal.")){
            NPCs.closest("Quest Guide").interact("Talk-to");
            return sleepMedium();
        }
        if (textboxWidget().isVisible()
                && textboxWidget().getText().contains("Quest journal")) {
            questWidget().interact();
            return sleepMedium();
        }
        if (textboxWidget().getText().contains("Quests") && textboxWidget().isVisible()) {
            NPCs.closest("Quest Guide").interact("Talk-to");
            return sleepMedium();
        }
        if (new Area(3084, 3128, 3087, 3126).contains(localPlayer())) {
            GameObjects.closest("Door").interact();
            return sleepMedium();
        }
        if (outsideQuest.contains(localPlayer())) {
            Walking.walk(new Area(3084, 3128, 3087, 3126).getRandomTile());
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

        return sleepMedium();
    }
}