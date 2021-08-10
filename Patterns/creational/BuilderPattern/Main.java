package com.prokopovich.patterns.builderpattern;

import com.prokopovich.patterns.builderpattern.builder.OnlineStoreBuilder;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        OnlineStoreBuilder firstBuilder = new OnlineStoreBuilder();
        director.constructFirstStore(firstBuilder);
        OnlineStore firstStore = firstBuilder.getOnlineStore();
        System.out.println(firstStore.toString());

        OnlineStoreBuilder secondBuilder = new OnlineStoreBuilder();
        director.constructSecondStore(secondBuilder);
        OnlineStore secondStore = secondBuilder.getOnlineStore();
        System.out.println(secondStore.toString());
    }
}

