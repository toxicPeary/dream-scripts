package value;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.utilities.Timer;

import java.awt.*;
import value.WidgetLib.*;

public class Constants {
    public static final Area cookingInside = new Area(
            new Tile[]{
                    new Tile(3078,3083),
                    new Tile(3076, 3083),
                    new Tile(3076, 3082),
                    new Tile(3075, 3082),
                    new Tile(3075, 3085),
                    new Tile(3074, 3085),
                    new Tile(3074, 3089),
                    new Tile(3073, 3089),
                    new Tile(3073, 3090),
                    new Tile(3075, 3090),
                    new Tile(3075, 3085),
                    new Tile(3078, 3085),

            }
    );
    public static final Area firstCookDoor = new Area(3081, 3083, 3079, 3086);
    public static final Area outsideQuest = new Area(
            new Tile[] {
                    new Tile(3077, 3092, 0),
                    new Tile(3077, 3098, 0),
                    new Tile(3082, 3098, 0),
                    new Tile(3083, 3099, 0),
                    new Tile(3083, 3104, 0),
                    new Tile(3084, 3105, 0),
                    new Tile(3084, 3107, 0),
                    new Tile(3085, 3108, 0),
                    new Tile(3085, 3109, 0),
                    new Tile(3087, 3111, 0),
                    new Tile(3087, 3112, 0),
                    new Tile(3090, 3115, 0),
                    new Tile(3094, 3115, 0),
                    new Tile(3094, 3123, 0),
                    new Tile(3095, 3124, 0),
                    new Tile(3095, 3126, 0),
                    new Tile(3094, 3127, 0),
                    new Tile(3094, 3130, 0),
                    new Tile(3093, 3131, 0),
                    new Tile(3093, 3133, 0),
                    new Tile(3069, 3133, 0),
                    new Tile(3071, 3126, 0),
                    new Tile(3065, 3111, 0),
                    new Tile(3065, 3103, 0),
                    new Tile(3057, 3101, 0),
                    new Tile(3055, 3095, 0),
                    new Tile(3064, 3088, 0),
                    new Tile(3066, 3082, 0),
                    new Tile(3072, 3082, 0),
                    new Tile(3073, 3083, 0),
                    new Tile(3073, 3087, 0),
                    new Tile(3074, 3087, 0),
                    new Tile(3074, 3089, 0),
                    new Tile(3073, 3089, 0),
                    new Tile(3073, 3092, 0),
                    new Tile(3077, 3092, 0),
                    new Tile(3080, 3119, 0),
                    new Tile(3090, 3119, 0),
                    new Tile(3090, 3126, 0),
                    new Tile(3082, 3126, 0),
                    new Tile(3080, 3124, 0),
                    new Tile(3080, 3119, 0)
            }
    );
    public static final Area insideQuest = new Area(
            new Tile[]{
                    new Tile(3080, 3119, 0),
                    new Tile(3080, 3123, 0),
                    new Tile(3082, 3125, 0),
                    new Tile(3089, 3125, 0),
                    new Tile(3089, 3119, 0)
            }
    );
    public static final Area prayerArea = new Area(
            new Tile[] {
                    new Tile(3120, 3110, 0),
                    new Tile(3129, 3111, 0),
                    new Tile(3129, 3123, 0),
                    new Tile(3133, 3128, 0),
                    new Tile(3146, 3123, 0),
                    new Tile(3150, 3104, 0),
                    new Tile(3149, 3103, 0),
                    new Tile(3120, 3103, 0)
            }
    );
    public static final Area closeSurvivalExpert = new Area(3098, 3198, 3106, 3093);
    public static final Area miningArea = new Area(3071, 9512, 3094, 9493);
    public static final Area combatArea = new Area(3095, 9534, 3120, 9490);
    public static final Area combatTut = new Area(3103, 9503, 3110, 9514);

    public static final int i = Calculations.random(1,5);
    public static final Area[] choppingWood = {
            new Area(3193, 3372, 3210, 3363),
            new Area(3072, 3306, 3108, 3282),
            new Area(3199, 3206, 3175, 3233),
            new Area(3142, 3235, 3176, 3209),
            new Area(3136, 3264, 3194, 3232),
            new Area(3171, 3372, 3155, 3402),
            new Area(3063, 3419, 3036, 3455),
            new Area(3008, 3241, 2984, 3271),
            new Area(2997, 3278, 2950, 3307),
            new Area(3019, 3148, 2999, 3175),
            new Area(3299, 3333, 3271, 3349),
            new Area(3270, 3356, 3254, 3372),
            new Area(3284, 3426, 3271, 3459)
    };
    public static final Timer timer = new Timer(Calculations.random(300_000,600_000));

}
