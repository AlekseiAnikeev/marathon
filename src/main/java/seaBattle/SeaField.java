package seaBattle;

import java.util.Arrays;

public class SeaField {

    private final GameObject[][] board;
    private final String playerName;
    private final GameObject[][] shotField;


    public SeaField(GameObject[][] board, String playerName) {
        this.board = board;
        this.playerName = playerName;
        shotField = new GameObject[10][10];
        for (GameObject[] gameObjects : shotField) {
            Arrays.fill(gameObjects, GameObject.EMPTY);
        }
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

