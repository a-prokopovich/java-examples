package com.prokopovich.iostreams.closeio;

public class CloseIOStreamsExample {

    public static void main(String[] args) {
        System.out.print("Read line from file: ");
        try (CustomInputResource resource = new CustomInputResource()) {
            StringBuilder line = resource.read();
            System.out.println("Read from file: " + line);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
