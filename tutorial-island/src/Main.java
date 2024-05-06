import behaviour.*;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.impl.TaskScript;

@ScriptManifest(
        name = "Tutorial Island",
        description = "Ordinary Tutorial Island Script",
        author = "toxicPeary",
        version = 1.0,
        category = Category.MISC)

public class Main extends TaskScript {
    @Override
    public void onStart() {
        addNodes(
                new InputName(),
                new ChangeLook(),
                new GuidePart(),
                new SurvivalPart(),
                new CookPart(),
                new GuidePart());
    }


}