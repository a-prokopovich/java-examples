package com.prokopovich.iostreams;

import java.io.*;
import java.util.Scanner;

public class BufferedStreamsExample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File file = new File("BufferedStreamsExample.txt");
        System.out.print("Enter the line: ");
        String line = in.nextLine();
        try {
            writeLine(line, file);
            String lineFromFile = readLine(file);
            System.out.println("Read line from file: " + lineFromFile);
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void writeLine(String line, File file) throws IOException {
        FileOutputStream fout = new FileOutputStream(file);
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        byte byteLine[] = line.getBytes();
        bout.write(byteLine);
        bout.flush();
        bout.close();
        fout.close();
        System.out.println("The line was successfully written to the file.");
    }

    public static String readLine(File file) throws IOException {
        StringBuilder line = new StringBuilder();
        FileInputStream fin = new FileInputStream(file);
        BufferedInputStream bin = new BufferedInputStream(fin);
        int i = bin.read();
        while (i != -1) {
            line.append((char) i);
            i = bin.read();
        }
        bin.close();
        fin.close();
        return line.toString();
    }
}
