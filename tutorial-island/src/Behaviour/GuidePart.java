package Behaviour;

import Behaviour.Value.Constants;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;

public class GuidePart extends TaskNode {


    @Override
    public boolean accept() {
        Area start = new Area(3091, 3110, 3097, 3101);
        return start.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        if (!Widgets.get(231, 4).getText().contains("Gielinor Guide")) {
            Constants.guide.interact("Talk-to");
            sleep(Calculations.random(250, 1250));

            return Calculations.random(250, 1250);
        }
        return Calculations.random(250, 1250);
    }
}
