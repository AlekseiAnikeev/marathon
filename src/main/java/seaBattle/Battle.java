package seaBattle;

import java.util.Random;
import java.util.Scanner;

import static seaBattle.UtilMethod.*;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.04.2022
 */

public class Battle {
    private int player1ShipCount = 10;
    private int player2ShipCount = 10;
    private boolean gameOver = false;
    private boolean startPlayer;
    private final boolean onePlayer;
    private final SeaField fieldPlayer1;
    private final SeaField fieldPlayer2;


    public Battle(SeaField fieldPlayer1, SeaField fieldPlayer2, boolean onePlayer) {
        this.fieldPlayer1 = fieldPlayer1;
        this.fieldPlayer2 = fieldPlayer2;
        this.onePlayer = onePlayer;
    }


    @SuppressWarnings("BusyWait")
    public void play() {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);

        int start = rnd.nextInt(2);
        startPlayer = start == 0;
        if (onePlayer) {
            while (!gameOver) {
                String coordinateShots;
                if (startPlayer) {
                    fieldPlayer1.printShotField();
                    System.out.println("Твой ход " + fieldPlayer1.getPlayerName() + "! Введи координаты выстрела в формате х,у: ");
                    coordinateShots = scanner.nextLine();
                } else {
                    fieldPlayer2.printShotField();
                    System.out.println("Ходит " + fieldPlayer2.getPlayerName());
                    while(true) {
                        coordinateShots = rnd.nextInt(10) + "," + rnd.nextInt(10);
                        int[] shot = getIntsCoordinate(coordinateShots);
                        if(fieldPlayer1.getBoard()[shot[1]][shot[0]].getMeaning() < 5){
                            break;
                        }
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


                while (move(startPlayer, coordinateShots)) {
                    System.out.println("Ошибка ввода, попробуй еще раз");
                    if (!startPlayer) {
                        coordinateShots = rnd.nextInt(10) + "," + rnd.nextInt(10);
                    } else {
                        coordinateShots = scanner.nextLine();
                    }
                }
            }
        } else {
            while (!gameOver) {
                if (startPlayer) {
                    fieldPlayer1.printShotField();
                    System.out.println("Твой ход " + fieldPlayer1.getPlayerName() + "! Введи координаты выстрела в формате х,у: ");
                } else {
                    fieldPlayer2.printShotField();
                    System.out.println("Твой ход " + fieldPlayer2.getPlayerName() + "! Введи координаты выстрела в формате х,у: ");
                }
                String coordinateShots = scanner.nextLine();

                while (move(startPlayer, coordinateShots)) {
                    System.out.println("Ошибка ввода, попробуй еще раз");
                    coordinateShots = scanner.nextLine();
                }
            }
        }
    }

    private boolean move(boolean startPlayer, String coordinate) {
        if (!checkShotCondition(coordinate)) {
            return true;
        }
        if (startPlayer) {
            shot(fieldPlayer2, fieldPlayer1, getIntsCoordinate(coordinate));
        } else {
            shot(fieldPlayer1, fieldPlayer2, getIntsCoordinate(coordinate));
        }
        if (player1ShipCount == 0) {
            gameOver = true;
            System.out.println("GAME OVER! \n" + "ПОБЕДИТЕЛЬ: " + fieldPlayer2.getPlayerName());
        }
        if (player2ShipCount == 0) {
            gameOver = true;
            System.out.println("GAME OVER! \n" + "ПОБЕДИТЕЛЬ: " + fieldPlayer1.getPlayerName());
        }
        return false;
    }

    private void shot(SeaField field, SeaField shotField, int[] coordinateShots) {
        if (field.getBoard()[coordinateShots[1]][coordinateShots[0]].getMeaning() == 1) {
            field.getBoard()[coordinateShots[1]][coordinateShots[0]] = GameObject.DAMAGE;
            if (hitOnTheShip(field, coordinateShots)) {
                System.out.println("Утопил");
                shotField.getShotField()[coordinateShots[1]][coordinateShots[0]] = GameObject.DAMAGE;
                if (startPlayer) {
                    player2ShipCount--;
                } else {
                    player1ShipCount--;
                }

            } else {
                shotField.getShotField()[coordinateShots[1]][coordinateShots[0]] = GameObject.DAMAGE;
                System.out.println("Попадание!");
            }

        } else {
            shotField.getShotField()[coordinateShots[1]][coordinateShots[0]] = GameObject.HALO;
            System.out.println("Промах!");
            startPlayer = !startPlayer;
        }
    }
}
