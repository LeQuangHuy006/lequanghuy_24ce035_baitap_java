package org.example.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ChatClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private TextArea messageArea;

    public ChatClient(TextArea messageArea) {
        this.messageArea = messageArea;
    }

    public boolean connect(String host, int port) {
        try {
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Platform.runLater(() -> messageArea.appendText("Initiating connection to " + host + ":" + port + "\n"));
            new Thread(this::receiveMessages).start();
            return true;
        } catch (Exception e) {
            Platform.runLater(() -> messageArea.appendText("Connection failed to " + host + ":" + port + ": " + e.getMessage() + "\n"));
            return false;
        }
    }

    public void sendMessage(String message) {
        if (out != null) {
            out.println(message);
            out.flush();
        }
    }

    private void receiveMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                String finalMessage = message;
                Platform.runLater(() -> {
                    messageArea.appendText(finalMessage + "\n");
                    messageArea.setScrollTop(Double.MAX_VALUE);
                });
            }
        } catch (Exception e) {
            Platform.runLater(() -> messageArea.appendText("Error receiving message: " + e.getMessage() + "\n"));
        } finally {
            Platform.runLater(() -> messageArea.appendText("Connection closed\n"));
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void disconnect() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}