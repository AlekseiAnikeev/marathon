package seaBattle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static seaBattle.Ai.aiGetCoordinate;
import static seaBattle.FormatValidation.isVertical;
import static seaBattle.UtilMethod.*;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.04.2022
 */

public class AddingShips {
    private static boolean inputError = true;
    private static final String[] formatShip = new String[]{
            "%s введи координаты %s%s корабля формат: %s\n",
            "x,y;x,y;x,y;x,y\n", "четырехпалубного", "трехпалубного", "двухпалубного", "однопалубного"
    };
    private static final String[] serialNumber = new String[]{
            "", "первого ", "вторго ", "первого ", "второго ", "третьего ", "первого ", "второго ", "третьего ", "четвертого "
    };

    private final GameObject[][] field;
    private boolean intersection;
    private final String player;

    public AddingShips(GameObject[][] field, String player, boolean onePlayer) {
        this.field = field;
        this.player = player;
        addShips(this.field, onePlayer);
    }


    private void addShips(GameObject[][] field, boolean onePlayer) {
        //Заполнение поля пустыми ячейками
        fillArrays(field);
        //цикл для определения координат по количеству кораблей
        if (!onePlayer) {
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    getCoordinates(field, new Scanner(System.in), GameObject.FOUR_DECK_SHIP, i);
                }
                if (i == 1 || i == 2) {
                    getCoordinates(field, new Scanner(System.in), GameObject.THREE_DECK_SHIP, i);
                }
                if (i > 2 && i <= 5) {
                    getCoordinates(field, new Scanner(System.in), GameObject.TWO_DECK_SHIP, i);
                }
                if (i > 5) {
                    getCoordinates(field, new Scanner(System.in), GameObject.ONE_DECK_SHIP, i);
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    aiGetCoordinate(field, GameObject.FOUR_DECK_SHIP);
                }
                if (i == 1 || i == 2) {
                    aiGetCoordinate(field, GameObject.THREE_DECK_SHIP);
                }
                if (i > 2 && i <= 5) {
                    aiGetCoordinate(field, GameObject.TWO_DECK_SHIP);
                }
                if (i > 5) {
                    aiGetCoordinate(field, GameObject.ONE_DECK_SHIP);
                }
            }
        }
    }

    private void fillArrays(GameObject[][] field) {
        for (GameObject[] gameObjects : field) {
            Arrays.fill(gameObjects, GameObject.EMPTY);
        }
        field[10][0] = GameObject.ZERO;
        field[10][1] = GameObject.ONE;
        field[10][2] = GameObject.TWO;
        field[10][3] = GameObject.THREE;
        field[10][4] = GameObject.FOUR;
        field[10][5] = GameObject.FIVE;
        field[10][6] = GameObject.SIX;
        field[10][7] = GameObject.SEVEN;
        field[10][8] = GameObject.EIGHT;
        field[10][9] = GameObject.NINE;

        field[0][10] = GameObject.ZERO;
        field[1][10] = GameObject.ONE;
        field[2][10] = GameObject.TWO;
        field[3][10] = GameObject.THREE;
        field[4][10] = GameObject.FOUR;
        field[5][10] = GameObject.FIVE;
        field[6][10] = GameObject.SIX;
        field[7][10] = GameObject.SEVEN;
        field[8][10] = GameObject.EIGHT;
        field[9][10] = GameObject.NINE;
    }

    private void getCoordinates(GameObject[][] field, Scanner scanner, GameObject ship, int i) {
        List<Integer> coordinate;
        int numberOfDecks;
        String format;
        //узнаем колчество палуб корабля для форматирования текста.
        switch (ship.getValue()) {
            case 4:
                numberOfDecks = 2;
                format = formatShip[1];
                break;
            case 3:
                numberOfDecks = 3;
                format = formatShip[1].substring(0, 11);
                break;
            case 2:
                numberOfDecks = 4;
                format = formatShip[1].substring(0, 7);
                break;
            default:
                numberOfDecks = 5;
                format = formatShip[1].substring(0, 3);
                break;
        }
        //просим координаты у игроков
        while (inputError) {
            System.out.printf(formatShip[0], player, serialNumber[i], formatShip[numberOfDecks], format);
            coordinate = new FormatValidation().addCoordinates(scanner, ship);
            if (coordinate.size() != 0) {
                intersection = intersectionShip(field, coordinate, ship, isVertical());
            }
            if (coordinate.size() != 0 && intersection) {
                inputError = false;
                drawHaloInField(field, coordinate, ship, isVertical());
                drawShipInField(field, coordinate, ship, isVertical());
                for (GameObject[] gameObject : field) {
                    for (int j = 0; j < field.length; j++) {
                        System.out.print(gameObject[j].getTexture() + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            } else System.out.println("Попробуй еще раз!");
        }
        inputError = true;
    }

    public GameObject[][] getField() {
        return field;
    }
}
