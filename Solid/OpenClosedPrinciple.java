package com.prokopovich.solid.ocp;

public class Singer {
    private String name;

    public Singer(String name) {
        this.name = name;
    }

    public void singSong() {
        System.out.print(name + " sings a song");
    }
}

public class RockMusician extends Singer {
    private String musicalInstrument;

    public RockMusician(String name, String musicalInstrument) {
        super(name);
        this.musicalInstrument = musicalInstrument;
    }

    public void playMusicalInstrument() {
        System.out.print("play " + musicalInstrument);
    }
}

public class Main {
    public static void main(String[] args) {
        Singer singer = new Singer("Beyonce");
        singer.singSong();
        System.out.println();
        RockMusician rockMusician = new RockMusician("Tom Delonge", "guitar");
        rockMusician.singSong();
        System.out.print(" and ");
        rockMusician.playMusicalInstrument();
    }
}
