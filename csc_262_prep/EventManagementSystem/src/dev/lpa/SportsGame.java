package dev.lpa;

import java.util.List;

public class SportsGame extends Event {
    private String sportsType;
    private String competingTeams;

    public SportsGame(String name, String date) {
        super(name, date);
    }

    @Override
    public String displayDetails() {
        return super.displayDetails() + " Sports Type: " + sportsType + "\n" +
                "Competing Teams: " + competingTeams + "\n";
    }
}
