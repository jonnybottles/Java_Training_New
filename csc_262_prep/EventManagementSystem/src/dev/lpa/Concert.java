package dev.lpa;

import java.util.List;

public class Concert extends Event {
    private String artist;
    private String genre;

    public Concert(String name, String date, String artist, String genre) {
        super(name, date);
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public String displayDetails() {
        return super.displayDetails() + " Artist: " + artist + "\n" +
                "Genres: " + genre + "\n";
    }
}
