package com.prokopovich;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TelnetServer implements Runnable {

    private static final int PORT = 8040;

    private final Socket clientSocket;
    private final int clientID;

    public TelnetServer(Socket clientSocket, int clientID) {
        this.clientSocket = clientSocket;
        this.clientID = clientID;
    }

    public static void main(String[] args) throws IOException {

        var serverSocket = new ServerSocket(PORT);
        System.out.println("Server is start.\nWaiting for connection . . .");
        int countConnection = 0;

        while (true) {
            Socket socket = serverSocket.accept();
            countConnection++;
            System.out.println("Client " + countConnection + " connected . . . ");

            TelnetServer telnetServer = new TelnetServer(socket, countConnection);
            Thread thread = new Thread(telnetServer);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            out.write("\nHello! (write a massage or press Enter to exit)\n");
            out.flush();

            while (true) {
                out.write("\nEnter a message: ");
                out.flush();

                String message = in.readLine();
                if (message.equals("")) {
                    out.write("\nGoodbye!\n\n");
                    out.flush();
                    System.out.println("Client " + clientID + " disconnected.");
                    break;
                }

                System.out.println("Message by client " + clientID + ": " + message);

                out.write("Processed message: " + message + "\n");
                out.flush();
            }
            clientSocket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
