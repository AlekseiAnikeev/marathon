package seaBattle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static seaBattle.UtilMethod.*;


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

    public AddingShips(GameObject[][] field, String player) {
        this.field = field;
        this.player = player;
        addShips(this.field);
    }


    private void addShips(GameObject[][] field) {
        //Заполнение поля пустыми ячейками
        for (GameObject[] gameObjects : field) {
            Arrays.fill(gameObjects, GameObject.EMPTY);
        }
        //цикл для определения координат по количеству кораблей
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
                intersection = intersectionShip(field, coordinate, ship);
            }
            if (coordinate.size() != 0 && intersection) {
                inputError = false;
                drawHaloInField(field, coordinate, ship);
                drawShipInField(field, coordinate, ship);
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
