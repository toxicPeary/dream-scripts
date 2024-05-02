import Behaviour.ChangeLook;
import Behaviour.GuidePart;
import Behaviour.InputName;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.cache.nodes.impl.Node;

@ScriptManifest(
        name = "Tutorial Island",
        description = "Ordinary Tutorial Island Script",
        author = "toxicPeary",
        version = 1.0,
        category = Category.MISC)

public class Main extends TaskScript {
    @Override
    public void onStart() {
        addNodes(new InputName(), new ChangeLook(), new GuidePart());
    }


}