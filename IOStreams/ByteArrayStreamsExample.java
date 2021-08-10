package com.prokopovich.iostreams;

import java.io.*;
import java.util.Scanner;

public class ByteArrayStreamsExample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the line: ");
        String line = in.nextLine();
        try {
            writeLine(line);
            readLine(line);
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void writeLine(String line) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte byteLine[] = line.getBytes();
        out.write(byteLine);
        String streamData = out.toString();
        System.out.println("From output stream: " + streamData);
        out.close();
    }

    public static void readLine(String line) throws IOException {
        byte byteLine[] = line.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(byteLine);
        System.out.print("From input stream: ");
        for (int i = 0; i < byteLine.length; i++) {
            int data = in.read();
            System.out.print((char) data);
        }
        in.close();
    }
}
