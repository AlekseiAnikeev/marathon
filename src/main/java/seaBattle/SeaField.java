package seaBattle;

import java.util.Arrays;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.04.2022
 */

public class SeaField {

    private final GameObject[][] board;
    private final String playerName;
    private final GameObject[][] shotField;


    public SeaField(GameObject[][] board, String playerName) {
        this.board = board;
        this.playerName = playerName;
        shotField = getGameObjects();
    }

    private GameObject[][] getGameObjects() {
        final GameObject[][] shotField;
        shotField = new GameObject[11][11];
        for (GameObject[] gameObjects : shotField) {
            Arrays.fill(gameObjects, GameObject.EMPTY);
        }
        shotField[10][0] = GameObject.ZERO;
        shotField[10][1] = GameObject.ONE;
        shotField[10][2] = GameObject.TWO;
        shotField[10][3] = GameObject.THREE;
        shotField[10][4] = GameObject.FOUR;
        shotField[10][5] = GameObject.FIVE;
        shotField[10][6] = GameObject.SIX;
        shotField[10][7] = GameObject.SEVEN;
        shotField[10][8] = GameObject.EIGHT;
        shotField[10][9] = GameObject.NINE;

        shotField[0][10] = GameObject.ZERO;
        shotField[1][10] = GameObject.ONE;
        shotField[2][10] = GameObject.TWO;
        shotField[3][10] = GameObject.THREE;
        shotField[4][10] = GameObject.FOUR;
        shotField[5][10] = GameObject.FIVE;
        shotField[6][10] = GameObject.SIX;
        shotField[7][10] = GameObject.SEVEN;
        shotField[8][10] = GameObject.EIGHT;
        shotField[9][10] = GameObject.NINE;
        return shotField;
    }


    public GameObject[][] getBoard() {
        return board;
    }

    public GameObject[][] getShotField() {
        return shotField;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void print() {
        for (GameObject[] gameObject : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(gameObject[j].getTexture() + " ");
            }
            System.out.println();
        }
    }

    public void printShotField() {
        for (GameObject[] gameObject : shotField) {
            for (int j = 0; j < shotField.length; j++) {
                System.out.print(gameObject[j].getTexture() + " ");
            }
            System.out.println();
        }
    }
}

