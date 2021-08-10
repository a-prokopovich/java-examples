package com.prokopovich.solid.lsp;

public class Artist {
    protected String name;

    public Artist(String name) {
        this.name = name;
    }

    public void performOnStage() {
        System.out.println(name + " perform on stage");
    }
}

public class Singer extends Artist {

    public Singer(String name) {
        super(name);
    }

    @Override
    public void performOnStage() {
        System.out.println(super.name + " sings a song");
    }
}

public class RockMusician extends Artist {
    private String musicalInstrument;

    public RockMusician(String name, String musicalInstrument) {
        super(name);
        this.musicalInstrument = musicalInstrument;
    }

    @Override
    public void performOnStage() {
        System.out.println(super.name + " sings a song and play " + musicalInstrument);
    }
}

public class Main {

    public static void main(String[] args) {
        Artist artist = new Artist("Julia");
        Artist singer = new Singer("Beyonce");
        Artist rockMusician = new RockMusician("Tom Delonge", "guitar");
        artist.performOnStage();
        singer.performOnStage();
        rockMusician.performOnStage();
    }
}
