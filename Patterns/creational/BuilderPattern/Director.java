package com.prokopovich.patterns.builderpattern;

import com.prokopovich.patterns.builderpattern.builder.Builder;

import java.util.ArrayList;
import java.util.List;

public class Director {

    public void constructFirstStore(Builder builder) {
        builder.setName("1000 trifles");
        builder.setWebsite("1000.com");
        List<Address> storeAddresses = new ArrayList<>();
        storeAddresses.add(new Address("Belarus", "Minsk", "Kirova", "1A"));
        builder.setStoreAddresses(storeAddresses);
    }

    public void constructSecondStore(Builder builder) {
        builder.setName("Online-shop");
        builder.setWebsite("online-shop.com");
        List<Address> warehouseAddresses = new ArrayList<>();
        warehouseAddresses.add(new Address("Russia", "Moscow", "Lenina", "15"));
        builder.setWarehouseAddresses(warehouseAddresses);
        List<Address> pointDeliveryGoodsAddresses = new ArrayList<>();
        pointDeliveryGoodsAddresses.add(new Address("Russia", "Moscow", "Lenina", "25"));
        pointDeliveryGoodsAddresses.add(new Address("Russia", "Moscow", "Sovetskaya", "115"));
        builder.setPointDeliveryGoodsAddresses(pointDeliveryGoodsAddresses);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("phone", "74957556983", "Ivan"));
        contactList.add(new Contact("email", "ivan@mail.ru", "Ivan"));
        builder.setContactList(contactList);
    }
}
