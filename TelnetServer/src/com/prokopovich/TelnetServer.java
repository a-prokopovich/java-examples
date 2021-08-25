package com.prokopovich;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TelnetServer {

    private static final int PORT = 8040;

    public static void main(String[] args) throws IOException {

        Socket clientSocket;
        BufferedReader in;
        BufferedWriter out;

        var serverSocket = new ServerSocket(PORT);
        System.out.println("Server is start.\nWaiting for connection . . .");

        clientSocket = serverSocket.accept();
        System.out.println("Client connected.\nWaiting a message . . . ");

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        out.write("\nHello! (write a massage or press Enter to exit)\n");
        out.flush();

        while (true) {
            out.write("\nEnter a message: ");
            out.flush();

            String message = in.readLine();
            if (message.equals("")) {
                out.write("\nGoodbye!\n\n");
                out.flush();
                System.out.println("Client disconnected.");
                break;
            }

            System.out.println("Message by client: " + message);

            out.write("Processed message: " + message + "\n");
            out.flush();
        }
        clientSocket.close();
        in.close();
        out.close();
        serverSocket.close();
    }
}
