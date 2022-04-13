package seaBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) {
        GameObject[][] gameObjectPlayer1 = new GameObject[10][10];
        GameObject[][] gameObjectPlayer2 = new GameObject[10][10];

        System.out.println("Добро пожаловать в Морской Бой!\n");
        String player1Name = null;
        String player2Name = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Первый игрок введи имя: ");

        try {
            player1Name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Второй игрок введи имя: ");

        try {
            player2Name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Сейчас вам предстоит задать координаты кораблей!\n");
        System.out.printf("%s проверь, что твой коллега не смотрит в экран!\n", player1Name);
        SeaField fieldPlayer1 = new SeaField(new AddingShips(gameObjectPlayer1, player1Name).getField(), player1Name);
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        System.out.printf("%s будь внимателен, не дай подсмотреть :D\n", player2Name);
        SeaField fieldPlayer2 = new SeaField(new AddingShips(gameObjectPlayer2, player2Name).getField(), player2Name);

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        Battle game = new Battle(fieldPlayer1, fieldPlayer2);
        game.play();
    }
}

//    private String coordinate4 = "1,1;1,2;1,3;1,4";
//    private String coordinate3_1 = "3,5;4,5;5,5";
//    private String coordinate3_2 = "4,1;4,2;4,3";
//    private String coordinate2_1 = "0,7;0,6";
//    private String coordinate2_2 = "3,8;3,9";
//    private String coordinate2_3 = "7,4;7,3";
//    private String coordinate1_1 = "0,9";
//    private String coordinate1_2 = "9,9";
//    private String coordinate1_3 = "7,9";
//    private String coordinate1_4 = "5,9";
//    private String coordinate4 = "3,1;3,2;3,3;3,4";
//    private String coordinateB3_1 = "5,0;6,0;7,0";
//    private String coordinateB3_2 = "1,5;1,6;1,7";
//    private String coordinateB2_1 = "8,8;9,8";
//    private String coordinateB2_2 = "0,1;0,2";
//    private String coordinateB2_3 = "7,4;7,3";
//    private String coordinateB1_1 = "0,9";
//    private String coordinateB1_2 = "9,0";
//    private String coordinateB1_3 = "4,9";
//    private String coordinateB1_4 = "4,6";