package com.prokopovich.iostreams;

import java.io.FileInputStream;
import java.io.IOException;

public class MultipleIOStreamsExample {

    public static void main(String[] args) throws IOException {
        try {
            FileInputStream fin = new FileInputStream("MultipleIOStreamsExample.txt");
            fin.mark(0);
            int i = fin.read();
            while (i != -1) {
                System.out.println((char) i);
                i = fin.read();
            }
            if(fin.markSupported()) {
                fin.reset();
                System.out.println("First symbol: " + (char) fin.read());
            }
            fin.close();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
