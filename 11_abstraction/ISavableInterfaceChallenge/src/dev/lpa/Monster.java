package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Character implements ISaveable{

    public Monster(String name, int hitPoints, int strength) {
        super(name, hitPoints, strength);
    }

    @Override
    public List<String> write() {
        List<String> list = new ArrayList<String>();
        list.add(name);
        list.add(String.valueOf(hitPoints));
        list.add(String.valueOf(strength));
        return list;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && !savedValues.isEmpty()) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
        }
    }

    @Override
    public String toString() {
        return String.format(super.TO_STRING_FMT + "}", getClass().getName(), name, hitPoints, strength);
    }

}
