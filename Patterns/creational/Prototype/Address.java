package com.prokopovich.patterns.prototype;

import java.util.Objects;

public class Address implements AddressPrototype {
    private String country;
    private String city;
    private String street;
    private String building;

    private Address() { }

    public Address(String country, String city, String street, String building) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    @Override
    public Address clone() {
        Address addressClone = new Address();
        addressClone.country = this.country;
        addressClone.city = this.city;
        addressClone.street = this.street;
        addressClone.building = this.building;
        return addressClone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(building, address.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, building);
    }

    @Override
    public String toString() {
        return "address: " +
                "country = " + country +
                ", city = " + city +
                ", street = " + street +
                ", building = " + building;
    }
}
