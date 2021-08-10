package com.prokopovich.patterns.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Address> addressList = new ArrayList<>();

        addressList.add(new Address("Belarus", "Minsk", "Kirova", "13"));
        addressList.add(new Address("Belarus", "Minsk", "Bogdanovicha", "24"));
        addressList.add(new Address("Belarus", "Minsk", "Nemiga", "1"));
        addressList.add(new Address("Belarus", "Minsk", "Nezavisimosti", "113"));
        addressList.add(new Address("Belarus", "Minsk", "Sovietskaya", "51"));

        Person person = new Person();
        System.out.print("Hi. Call your name: ");
        String name = scanner.nextLine();
        person.setName(name);
        System.out.println("\nAddresses: ");
        for (int i = 0; i < (addressList.size()); i++) {
            System.out.println(i + ") " + addressList.get(i).toString());
        }
        System.out.print("Select your address: ");
        int numberAddress = scanner.nextInt();
        person.setAddress(addressList.get(numberAddress).clone());
        System.out.println("Information about you: \n" + person.toString());
        if(addressList.get(numberAddress).equals(person.getAddress())) {
            System.out.print("Addresses are equal.");
        }
    }
}
