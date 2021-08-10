package com.prokopovich.patterns.builderpattern.builder;

import com.prokopovich.patterns.builderpattern.Address;
import com.prokopovich.patterns.builderpattern.Contact;

import java.util.List;

public interface Builder {

    void setName(String name);

    void setWebsite(String website);

    void setStoreAddresses(List<Address> storeAddresses);

    void setWarehouseAddresses(List<Address> warehouseAddresses);

    void setPointDeliveryGoodsAddresses(List<Address> pointDeliveryGoodsAddresses);

    void setContactList(List<Contact> contactList);
}