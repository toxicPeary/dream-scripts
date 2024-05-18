/*
 * Decompiled with CFR 0.150.
 *//*

package net.runelite.client.plugins.mule;

import com.openosrs.client.ui.overlay.components.table.TableAlignment;
import com.openosrs.client.ui.overlay.components.table.TableComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.QuantityFormatter;

public class MuleOverlay
extends OverlayPanel {
    public static long startTime;
    public static int tradesCompleted;
    public static int goldRecieved;
    public static int goldGiven;

    public static String formatTime(long ms) {
        long s2 = ms / 1000L;
        long m3 = s2 / 60L;
        long h2 = m3 / 60L;
        long d = h2 / 24L;
        return d > 0L ? String.format("%02d:%02d:%02d:%02d", d, h2, m3, s2) : (h2 > 0L ? String.format("%02d:%02d:%02d", h2 %= 24L, m3, s2) : String.format("%02d:%02d", m3 %= 60L, s2 %= 60L));
    }

    public static double perHour(int item) {
        return (double)item * (3600000.0 / (double)(System.currentTimeMillis() - startTime));
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        TableComponent tableComponent = new TableComponent();
        tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);
        tableComponent.addRow("Runtime: " + MuleOverlay.formatTime(System.currentTimeMillis() - startTime));
        tableComponent.addRow("Trades completed: " + QuantityFormatter.formatNumber(tradesCompleted) + " (" + QuantityFormatter.formatNumber((int)MuleOverlay.perHour(tradesCompleted)) + ")");
        tableComponent.addRow("Gold recieved: " + QuantityFormatter.quantityToRSDecimalStack(goldRecieved, true) + " (" + QuantityFormatter.quantityToRSDecimalStack((int)MuleOverlay.perHour(goldRecieved), true) + ")");
        tableComponent.addRow("Gold given: " + QuantityFormatter.quantityToRSDecimalStack(goldGiven, true) + " (" + QuantityFormatter.quantityToRSDecimalStack((int)MuleOverlay.perHour(goldGiven), true) + ")");
        if (!tableComponent.isEmpty()) {
            this.panelComponent.setBackgroundColor(new Color(50, 50, 50, 94));
            this.panelComponent.setPreferredSize(new Dimension(200, 200));
            this.panelComponent.getChildren().add(TitleComponent.builder().text("Mule by castro").color(new Color(255, 0, 255)).build());
            this.panelComponent.getChildren().add(tableComponent);
        }
        return super.render(graphics);
    }
}

*/
