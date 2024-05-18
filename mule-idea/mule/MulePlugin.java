/*
 * Decompiled with CFR 0.150.
 */
package net.runelite.client.plugins.mule;

import net.runelite.client.plugins.muling.MuleServer;
import net.runelite.client.plugins.muling.Request;
import org.dreambot.api.Client;
import org.dreambot.api.ClientSettings;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.trade.Trade;
import org.dreambot.api.methods.trade.TradeUser;
import org.dreambot.api.methods.world.Worlds;
import org.dreambot.api.methods.worldhopper.WorldHopper;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManager;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.interactive.Player;



@ScriptManifest(category = Category.MISC, name = "Mule", author = "nottoxicPeary", version = 0.1)
public class MulePlugin
extends AbstractScript {
    private static String ourName;
    private boolean isItStarted;

    MuleServer server = new MuleServer();








    @Override
    public int onLoop() {

        if (Client.getForcedFPS() == 22) {
            MuleServer.stop();
        }


        if (!Client.isLoggedIn()) {
            return -1;
        }
        if (isItStarted && Client.isLoggedIn()) {
            //MuleOverlay.startTime = System.currentTimeMillis();
            new Thread(this.server).start();
            isItStarted = false;
        }
        if (ourName == null) {
            ourName = Players.getLocal().getName();
        }
        if (Request.username != null) {
            if (Worlds.getCurrentWorld() != Request.world) {
                WorldHopper.hopWorld(Request.world);
                return -1;
            }
            if (!Trade.isOpen()) {

                Player bot = Players.closest(Request.username);
                if (bot != null) {
                    bot.interact("Trade with");
                    sleepUntil(Trade::isOpen, Players.getLocal()::isMoving, 600, 5000);
                }
                if (System.currentTimeMillis() >= MuleServer.requestTime + 120000L) {
                    System.out.println("Resetting connection");
                    Request.lastTradeCompleted = System.currentTimeMillis();
                    Request.world = -1;
                    Request.type = null;
                    Request.username = null;
                    Request.coinAmount = 0;
                }
                return -1;
            }
            if (Trade.isOpen()) {
                if (Request.coinAmount > 1) {
                    if (!Trade.contains(false, "Coins")) {
                        Trade.addItem("Coins", Request.coinAmount);
                        return -5;
                    }
                }
                if (Trade.hasAcceptedTrade(TradeUser.THEM)) {
                    if (Trade.isOpen(2)) {
                        Request.lastTradeCompleted = System.currentTimeMillis();
                        Request.world = -1;
                        Request.type = null;
                        Request.username = null;
                        Request.coinAmount = 0;

                    }
                    Trade.acceptTrade();
                }
            }
            return -1;
        }
        return -1;
    }

    @Override
    public void onStart(String ... args2) {
        isItStarted = true;
    }

}

