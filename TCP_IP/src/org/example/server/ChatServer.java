package org.example.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static final int PORT = 12345;
    private static final List<PrintWriter> clients = new ArrayList<>();
    private static final List<String> messageHistory = new ArrayList<>(); // Lưu trữ lịch sử tin nhắn

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clients) {
                    clients.add(out);
                }

                synchronized (messageHistory) {
                    for (String pastMessage : messageHistory) {
                        out.println(pastMessage);
                        out.flush();
                    }
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    synchronized (messageHistory) {
                        messageHistory.add(message);
                    }
                    broadcast(message);
                }
            } catch (Exception e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                try {
                    synchronized (clients) {
                        clients.remove(out);
                    }
                    System.out.println("Client disconnected: " + socket.getRemoteSocketAddress());
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            synchronized (clients) {
                for (PrintWriter client : clients) {
                    client.println(message);
                    client.flush();
                }
            }
        }
    }
}