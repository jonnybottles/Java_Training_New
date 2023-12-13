package dev.lpa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a Player instance
        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim.toString()); // Validate toString output
        List<String> playerData = tim.write(); // Write data to a list

        // Create another Player instance and read data from the list
        Player secondPlayer = new Player("SecondPlayer", 0, 0);
        secondPlayer.read(playerData);
        System.out.println(secondPlayer.toString()); // Validate if data is read correctly

        // Create a Monster instance
        Monster werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf.toString()); // Validate toString output
        List<String> monsterData = werewolf.write(); // Write data to a list

        // Create another Monster instance and read data from the list
        Monster secondMonster = new Monster("SecondMonster", 0, 0);
        secondMonster.read(monsterData);
        System.out.println(secondMonster.toString()); // Validate if data is read correctly
    }
}
