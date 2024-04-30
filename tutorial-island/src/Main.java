import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Logger;

@ScriptManifest(
        name = "Tutorial Island",
        description = "Ordinary Tutorial Island Script",
        author = "toxicPeary",
        version = 1.0,
        category = Category.MISC)
public class Main extends AbstractScript {

    @Override
    public int onLoop() {
        return Calculations.random(500, 1900);
    }

}