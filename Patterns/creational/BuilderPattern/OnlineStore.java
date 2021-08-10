package com.prokopovich.patterns.builderpattern;

import java.util.List;

public class OnlineStore {
    private String name;
    private String website;
    private List<Address> storeAddresses;
    private List<Address> warehouseAddresses;
    private List<Address> pointDeliveryGoodsAddresses;
    private List<Contact> contactList;

    public OnlineStore(String name, String website, List<Address> storeAddresses, List<Address> warehouseAddresses,
                       List<Address> pointDeliveryGoodsAddresses, List<Contact> contactList) {
        this.name = name;
        this.website = website;
        this.storeAddresses = storeAddresses;
        this.warehouseAddresses = warehouseAddresses;
        this.pointDeliveryGoodsAddresses = pointDeliveryGoodsAddresses;
        this.contactList = contactList;
    }

    @Override
    public String toString() {
        String info = "OnlineStore: ";
        info += "name = " + name;
        info += " website = " + website;
        if (this.storeAddresses != null) {
            info += " storeAddresses: " + storeAddresses;
        }
        if (this.warehouseAddresses != null) {
            info += " warehouseAddresses: " + warehouseAddresses;
        }
        if (this.pointDeliveryGoodsAddresses != null) {
            info += " pointDeliveryGoodsAddresses: " + pointDeliveryGoodsAddresses;
        }
        if (this.contactList != null) {
            info += " contactList:" + contactList;
        }
        return info;
    }
}
