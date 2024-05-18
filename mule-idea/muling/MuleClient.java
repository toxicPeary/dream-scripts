/*
 * Decompiled with CFR 0.150.
 */
package net.runelite.client.plugins.muling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MuleClient {
    public static String response;
    public static long responseTime;
    public static long lastRequest;
    public static int timeout;
    public static Socket socket;
    public static OutputStream outputStream;
    public static DataOutputStream dataOutputStream;
    public static InputStream inputStream;

    public static void connect(String host, int port) {
        try {
            socket = new Socket(host, port);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        if (socket != null && socket.isConnected()) {
            try {
                socket.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendRequest(String host, int port, String message) {
        if (System.currentTimeMillis() >= lastRequest + (long)timeout) {
            try {
                MuleClient.connect(host, port);
                if (socket != null && socket.isConnected()) {
                    outputStream = socket.getOutputStream();
                    dataOutputStream = new DataOutputStream(outputStream);
                    inputStream = socket.getInputStream();
                    dataOutputStream.writeUTF(message);
                    dataOutputStream.flush();
                    InputStream inputStream2 = socket.getInputStream();
                    DataInputStream dataInputStream = new DataInputStream(inputStream2);
                    response = dataInputStream.readUTF();
                    responseTime = System.currentTimeMillis();
                    System.out.println("Response: " + response);
                    lastRequest = System.currentTimeMillis();
                } else {
                    System.out.println("Socket is not connected");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        timeout = 15000;
    }
}

