package com.prokopovich.patterns.builderpattern;

public class Contact {
    private String type;
    private String value;
    private String contactPersonName;

    public Contact(String type, String value, String contactPersonName) {
        this.type = type;
        this.value = value;
        this.contactPersonName = contactPersonName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", contactPersonName='" + contactPersonName + '\'' +
                '}';
    }
}
