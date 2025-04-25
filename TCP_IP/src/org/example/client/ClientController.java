package org.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientController {
    @FXML
    private TextField input;
    @FXML
    private Button enter;
    @FXML
    private TextField idAndPort;
    @FXML
    private TextField username;
    @FXML
    private Button ketNoi;
    @FXML
    private TextArea lichSuTinNhan;

    private ChatClient client;
    private String user;

    @FXML
    void connectToServer(ActionEvent event) {
        user = username.getText().trim();
        if (user.isEmpty()) {
            lichSuTinNhan.appendText("Please enter a username\n");
            return;
        }

        String[] parts = idAndPort.getText().trim().split(":");
        if (parts.length != 2) {
            lichSuTinNhan.appendText("Invalid format. Use IP:Port (e.g., localhost:12345)\n");
            return;
        }

        String host = parts[0].trim();
        int port;
        try {
            port = Integer.parseInt(parts[1].trim());
        } catch (NumberFormatException e) {
            lichSuTinNhan.appendText("Invalid port number: " + parts[1] + "\n");
            return;
        }

        client = new ChatClient(lichSuTinNhan);
        if (client.connect(host, port)) {
            lichSuTinNhan.appendText("Connected to server at " + host + ":" + port + "\n");
            ketNoi.setDisable(true);
            enter.setDisable(false);
            input.setDisable(false);
            username.setDisable(true);
        } else {
            lichSuTinNhan.appendText("Failed to connect to server at " + host + ":" + port + "\n");
        }
    }

    @FXML
    void sendMessage(ActionEvent event) {
        String message = input.getText().trim();
        if (!message.isEmpty()) {
            client.sendMessage(user + ": " + message);
            input.clear();
        }
    }
}