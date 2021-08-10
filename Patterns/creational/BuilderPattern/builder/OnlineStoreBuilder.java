package com.prokopovich.patterns.builderpattern.builder;

import com.prokopovich.patterns.builderpattern.Address;
import com.prokopovich.patterns.builderpattern.Contact;
import com.prokopovich.patterns.builderpattern.OnlineStore;

import java.util.List;

public class OnlineStoreBuilder implements Builder {
    private String name;
    private String website;
    private List<Address> storeAddresses;
    private List<Address> warehouseAddresses;
    private List<Address> pointDeliveryGoodsAddresses;
    private List<Contact> contactList;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public void setStoreAddresses(List<Address> storeAddresses) {
        this.storeAddresses = storeAddresses;
    }

    @Override
    public void setWarehouseAddresses(List<Address> warehouseAddresses) {
        this.warehouseAddresses = warehouseAddresses;
    }

    @Override
    public void setPointDeliveryGoodsAddresses(List<Address> pointDeliveryGoodsAddresses) {
        this.pointDeliveryGoodsAddresses = pointDeliveryGoodsAddresses;
    }

    @Override
    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public OnlineStore getOnlineStore() {
        return new OnlineStore(name, website, storeAddresses, warehouseAddresses,
                pointDeliveryGoodsAddresses, contactList);
    }
}
