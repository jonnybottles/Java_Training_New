package dev.lpa;

public abstract  class Character {


    protected String TO_STRING_FMT = """
            "%s"{name='"%s"', hitPoints="%d", strength="%d" """;

    protected String name;
    protected int hitPoints;
    protected int strength;


    public Character(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public String toString() {
        return String.format(TO_STRING_FMT, getClass().getName(), name, hitPoints, strength);
    }
}
