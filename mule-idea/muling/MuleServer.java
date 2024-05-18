/*
 * Decompiled with CFR 0.150.
 */
package net.runelite.client.plugins.muling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.world.Worlds;

public class MuleServer
implements Runnable {
    public static int port = 3002;
    public static long requestTime;
    public static Socket socket;
    public static ServerSocket ss;
    public static OutputStream outputStream;
    public static DataOutputStream dataOutputStream;
    public static InputStream inputStream;
    protected static volatile boolean running;

    public static boolean getRunning() {
        return running;
    }

    public static void stop() {
        try {
            if (ss != null && !ss.isClosed()) {
                System.out.println("Closing ss");
                ss.close();
            }
            if (socket != null && socket.isConnected()) {
                System.out.println("Closing s");
                socket.close();
            }
        }
        catch (IOException e) {
            System.out.println("Error closing ss/s");
            e.printStackTrace();
        }
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Server is running...");
            System.out.println("[REQUEST]: Username: " + Request.username + ", world: " + Request.world + ", amount: " + Request.coinAmount);
            if (Request.username == null && Players.getLocal().getName() != null) {
                ss = null;
                try {
                    ss = new ServerSocket(port);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting for a connection...");
                try {
                    if (ss == null) {
                        System.out.println("SS IS NULL; ATTEMPTING TO RESET");
                        ss = new ServerSocket(port);
                    } else {
                        Socket socket = ss.accept();
                        System.out.println("Connection from " + socket + "!");
                        outputStream = socket.getOutputStream();
                        dataOutputStream = new DataOutputStream(outputStream);
                        inputStream = socket.getInputStream();
                        InputStream inputStream2 = socket.getInputStream();
                        DataInputStream dataInputStream = new DataInputStream(inputStream2);
                        String message = dataInputStream.readUTF();
                        System.out.println(message);
                        if (Request.username == null) {
                            String[] details = message.split(":");
                            Request.type = details[0];
                            Request.username = details[1];
                            Request.world = Integer.parseInt(details[2]);
                            Request.coinAmount = Integer.parseInt(details[3]);
                            System.out.println("Request details: TYPE: " + Request.type + ", Username: " + Request.username + ", World: " + Request.world + ", CoinAmount: " + Request.coinAmount);
                            String dataToSend = Players.getLocal().getName() + ":" + Worlds.getCurrentWorld();
                            System.out.println("DATA SENT: " + dataToSend);
                            requestTime = System.currentTimeMillis();
                            dataOutputStream.writeUTF(dataToSend);
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            Request.lastTradeCompleted = System.currentTimeMillis();
                            System.out.println("Response sent: " + dataToSend);
                        }
                        ss.close();
                        socket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (System.currentTimeMillis() > requestTime + 120000L) {
                Request.world = -1;
                Request.type = null;
                Request.username = null;
                Request.coinAmount = 0;
            }
            try {
                Thread.sleep(200L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        running = true;
    }
}

