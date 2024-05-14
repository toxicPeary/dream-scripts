package behaviour;


import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.script.TaskNode;

public class TutFinished extends TaskNode {


    @Override
    public boolean accept() {
        return PlayerSettings.getConfig(281) == 1000;
    }

    @Override
    public int execute() {
        System.exit(0);
        return 100;

    }
}