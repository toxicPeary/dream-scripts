package value;

import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.widgets.WidgetChild;

public class WidgetLib {
    public static WidgetChild continueWidget() {
        return Widgets.get(231, 5);
    }
    public static WidgetChild experienceWidget() {
        return Widgets.get(219, 1, 0);
    }
    public static WidgetChild settingsMenu() {
        return Widgets.get(164, 41);
    }
}
