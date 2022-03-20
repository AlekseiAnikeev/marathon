package day7;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rand = new Random();
        Player player = new Player(rand.nextInt(11) + 90);
        Player player2 = new Player(rand.nextInt(11) + 90);
        Player player3 = new Player(rand.nextInt(11) + 90);
        Player player4 = new Player(rand.nextInt(11) + 90);
        Player player5 = new Player(rand.nextInt(11) + 90);
        Player player6 = new Player(rand.nextInt(11) + 90);
        Player.info();
        Player player7 = new Player(rand.nextInt(11) + 90);
        Player.info();
    }
}
