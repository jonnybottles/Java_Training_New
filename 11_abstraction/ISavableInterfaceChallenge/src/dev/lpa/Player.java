package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character implements ISaveable{

    private String weapon;

    public Player(String name, int hitPoints, int strength) {
        super(name, hitPoints, strength);
        this.weapon = "Sword";

    }

    public String getWeapon() {
        return weapon;
    }

    @Override
    public List<String> write() {
        List<String> list = new ArrayList<String>();
        list.add(name);
        list.add(String.valueOf(hitPoints));
        list.add(String.valueOf(strength));
        list.add(weapon);
        return list;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && !savedValues.isEmpty()) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }
    }

    @Override
    public String toString() {
        return String.format(super.TO_STRING_FMT + ", weapon='%s'}", getClass().getName(), name, hitPoints, strength, getWeapon());    }
}
