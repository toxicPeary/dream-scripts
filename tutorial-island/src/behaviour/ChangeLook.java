package behaviour;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.Logger;

public class ChangeLook extends TaskNode {


    @Override
    public boolean accept() {

        return Widgets.get(679, 12) != null && Widgets.get(679, 12).isVisible();

    }

    @Override
    public int execute() {
        Logger.info("executing Change Look");

        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 13).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 17).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 21).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 25).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 29).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 33).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 37).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 41).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 44).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 48).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 52).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 56).interact();
            sleep(Calculations.random(250, 1250));
        }
        for (int i = 1; i < Calculations.random(1, 10); i++) {
            Widgets.get(679, 60).interact();
            sleep(Calculations.random(250, 1250));
        }
        Widgets.get(679, 68).interact();
        return Calculations.random(250, 1250);
    }
}
