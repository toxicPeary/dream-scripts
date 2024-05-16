package behaviour;


import org.dreambot.api.Client;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.utilities.Timer;
import value.WidgetLib;

import java.awt.*;

import static value.Constants.*;
public class TutFinished extends TaskNode {

    boolean timerStarted = false;

    @Override
    public boolean accept() {
        return PlayerSettings.getConfig(281) == 1000;
    }

    @Override
    public int execute() {
        Logger.info("executing tut finished part");

            Rectangle rectangle = new
                    Rectangle(WidgetLib.clickableScreen().getRectangle().x,
                    WidgetLib.clickableScreen().getRectangle().y,
                    WidgetLib.clickableScreen().getRectangle().width-1,
                    WidgetLib.clickableScreen().getRectangle().height-1);

        if (!timerStarted){
            timer.start();
            timerStarted = true;
        }

        if (!timer.finished()) {
            sleep(Calculations.random(120_000, 240_000));
            Mouse.click(rectangle,true);
        }

        if (timer.finished()) {
            System.exit(0);
        }

       /*
       if only afking doesn't work
       switch (i) {
            case 1:
                Logger.info("chopping wood");
                if (choppingWood.)
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
                }
                */








        return 100;

    }
}