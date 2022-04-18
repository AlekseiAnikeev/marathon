package seaBattle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static seaBattle.UtilMethod.*;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 17.04.2022
 */

public class Ai {
    public static void aiGetCoordinate(GameObject[][] field, GameObject ship) {
        List<Integer> coordinate = new ArrayList<>();
        boolean isVertical;

        Random random = new Random();
        int shipPosition = random.nextInt(2);
        while (true) {
            isVertical = shipPosition == 0;
            coordinate.add(random.nextInt(10));
            coordinate.add(random.nextInt(10));

            if (!coordinate.get(0).equals(coordinate.get(1))) {
                if (isVertical) {
                    for (int i = 1; i < ship.getValue(); i++) {
                        coordinate.add(coordinate.get(0));
                        if (coordinate.get(1) >= 7) {
                            coordinate.add(coordinate.get(1) - i);
                        } else if (coordinate.get(1) >= 0) {
                            coordinate.add(coordinate.get(1) + i);
                        }
                    }
                } else {
                    for (int i = 1; i < ship.getValue(); i++) {
                        if (coordinate.get(0) >= 7) {
                            coordinate.add(coordinate.get(0) - i);
                        } else if (coordinate.get(0) >= 0) {
                            coordinate.add(coordinate.get(0) + i);
                        }
                        coordinate.add(coordinate.get(1));
                    }
                }
            }
            System.out.println(coordinate);
            if(coordinate.size() != ship.getValue() * 2) {
                coordinate.clear();
                continue;
            }
            if (intersectionShip(field, coordinate, ship, isVertical)) {
                break;
            } else {
                coordinate.clear();
            }
        }
        drawHaloInField(field, coordinate, ship, isVertical);
        drawShipInField(field, coordinate, ship, isVertical);
        for (GameObject[] gameObject : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(gameObject[j].getTexture() + " ");
            }
            System.out.println();
        }
    }
}
