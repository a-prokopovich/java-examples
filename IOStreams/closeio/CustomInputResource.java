package com.prokopovich.iostreams.closeio;

import java.io.FileInputStream;
import java.io.IOException;

public class CustomInputResource implements AutoCloseable {
    private FileInputStream fin;

    public CustomInputResource() throws IOException {
        fin = new FileInputStream("resource.txt");
    }

    public StringBuilder read() throws IOException {
        StringBuilder line = new StringBuilder();
        int i = fin.read();
        while (i != -1) {
            line.append((char) i);
            i = fin.read();
        }
        return line;
    }

    @Override
    public void close() throws Exception {
        fin.close();
        System.out.println("Closed CustomResource");
    }
}
