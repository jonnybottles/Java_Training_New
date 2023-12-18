package dev.lpa;

import java.util.List;

public class Concert extends Event {
    private String artist;
    private String genre;

    public Concert(String name, String date) {
        super(name, date);
    }

    @Override
    public String displayDetails() {
        return super.displayDetails() + " Artist: " + artist + "\n" +
                "Genres: " + genre + "\n";
    }
}
