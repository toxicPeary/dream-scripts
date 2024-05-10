package value;

import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.NPC;

public class Constants {
    public static final Area cookingInside = new Area(
            new Tile[]{
                    new Tile(3073, 3091, 0),
                    new Tile(3077, 3091, 0),
                    new Tile(3078, 3086, 0),
                    new Tile(3078, 3082, 0),
                    new Tile(3076, 3080, 0),
                    new Tile(3074, 3080, 0),
                    new Tile(3073, 3083, 0)
            }
    );
    public static final Area outsideQuest = new Area(
            new Tile[]{
                    new Tile(3072, 3088, 0),
                    new Tile(3072, 3092, 0),
                    new Tile(3076, 3094, 0),
                    new Tile(3076, 3097, 0),
                    new Tile(3076, 3099, 0),
                    new Tile(3081, 3099, 0),
                    new Tile(3083, 3107, 0),
                    new Tile(3084, 3117, 0),
                    new Tile(3079, 3118, 0),
                    new Tile(3079, 3123, 0),
                    new Tile(3082, 3126, 0),
                    new Tile(3090, 3126, 0),
                    new Tile(3090, 3133, 0),
                    new Tile(3067, 3133, 0),
                    new Tile(3054, 3109, 0),
                    new Tile(3057, 3091, 0),
                    new Tile(3068, 3082, 0),
                    new Tile(3072, 3082, 0)
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
    public static final Area closeSurvivalExpert = new Area(3098, 3100, 3106, 3093);
    public static final Area miningArea = new Area(3071, 9512, 3094, 9493);
    public static final Area combatArea = new Area(3095, 9534, 3120, 9490);
    public static final Area combatTut = new Area(3103, 9503, 3110, 9514);
    public static final NPC combatInstructor = NPCs.closest("Combat Instructor");
}
