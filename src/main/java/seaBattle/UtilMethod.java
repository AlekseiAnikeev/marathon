package seaBattle;

import java.util.List;

import static seaBattle.GameObject.HALO;
/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.04.2022
 */

public class UtilMethod {

    private static final String errorText = "Ошибка расстановки корабля, необходимо помнить про \"ореол\" кораблей, который окружает корабли!";

    //метод проверки поля на отсутствие пересечений
    public static boolean intersectionShip(GameObject[][] field, List<Integer> coordinate, GameObject ship, boolean isVertical) {
        //проверка на количествопалуб
        if (ship.getValue() > 1) {
            if (isVertical) {
                //проверка координат на убывание/возрастание
                if (coordinate.get(1) < coordinate.get(3)) {
                    for (int i = 0; i < ship.getValue(); i++) {
                        if (!(field[coordinate.get(1) + i][coordinate.get(0)].getValue() == -1)) {
                            System.out.println(errorText);
                            return false;
                        }
                    }
                    //на убывание
                } else {
                    for (int i = 0; i < ship.getValue(); i++) {
                        if (!(field[coordinate.get(1) - i][coordinate.get(0)].getValue() == -1)) {
                            System.out.println(errorText);
                            return false;
                        }
                    }
                }
            } else {
                //проверка координат на убывание/возрастание
                if (coordinate.get(0) < coordinate.get(2)) {
                    for (int i = 0; i < ship.getValue(); i++) {
                        if (!(field[coordinate.get(1)][coordinate.get(0) + i].getValue() == -1)) {
                            System.out.println(errorText);
                            return false;
                        }
                    }
                    //на убывание
                } else {
                    for (int i = 0; i < ship.getValue(); i++) {
                        if (!(field[coordinate.get(1)][coordinate.get(0) - i].getValue() == -1)) {
                            System.out.println(errorText);
                            return false;
                        }
                    }
                }
            }
        } else {
            //проверка однопалубного
            if (!(field[coordinate.get(1)][coordinate.get(0)].getValue() == -1)) {
                System.out.println(errorText);
                return false;
            }
        }
        return true;
    }

    //отрисовка ореола
    public static void drawHaloInField(GameObject[][] field, List<Integer> coordinate, GameObject ship, boolean isVertical) {
        if (coordinate.size() > 2) {
            if (isVertical) {
                if (coordinate.get(1) < coordinate.get(3)) {
                    //рисуем ореол по правому борту
                    if (coordinate.get(0) + 1 < 10) {
                        for (int i = 0; i < ship.getValue(); i++) {
                            field[coordinate.get(1) + i][coordinate.get(0) + 1] = HALO;
                        }
                    }
                    //рисуем ореол по левому борту
                    if (coordinate.get(0) - 1 >= 0) {
                        for (int i = 0; i < ship.getValue(); i++) {
                            field[coordinate.get(1) + i][coordinate.get(0) - 1] = HALO;
                        }
                    }
                    //рисуем ореол верхнему борту
                    if (coordinate.get(1) - 1 >= 0) {
                        field[coordinate.get(1) - 1][coordinate.get(0)] = HALO;
                    }
                    //рисуем ореол верхний-правый борт
                    if (coordinate.get(1) - 1 >= 0 && coordinate.get(0) + 1 < 10) {
                        field[coordinate.get(1) - 1][coordinate.get(0) + 1] = HALO;
                    }
                    //рисуем ореол верхний-левый борт
                    if (coordinate.get(1) - 1 >= 0 && coordinate.get(0) - 1 >= 0) {
                        field[coordinate.get(1) - 1][coordinate.get(0) - 1] = HALO;
                    }
                    //рисуем ореол нижнему борту
                    if (coordinate.get(coordinate.size() - 1) + 1 < 10) {
                        field[coordinate.get(coordinate.size() - 1) + 1][coordinate.get(0)] = HALO;
                    }
                    //рисуем ореол нижний правый борт
                    if (coordinate.get(coordinate.size() - 1) + 1 < 10 && coordinate.get(0) + 1 < 10) {
                        field[coordinate.get(coordinate.size() - 1) + 1][coordinate.get(0) + 1] = HALO;
                    }
                    //рисуем ореол нижний левый борт
                    if (coordinate.get(coordinate.size() - 1) + 1 < 10 && coordinate.get(0) - 1 >= 0) {
                        field[coordinate.get(coordinate.size() - 1) + 1][coordinate.get(0) - 1] = HALO;
                    }
                } else {
                    //рисуем ореол по правому борту
                    if (coordinate.get(0) + 1 < 10) {
                        for (int i = 0; i < ship.getValue(); i++) {
                            field[coordinate.get(coordinate.size() - 1) + i][coordinate.get(0) + 1] = HALO;
                        }
                    }
                    //рисуем ореол по левому борту
                    if (coordinate.get(0) - 1 >= 0) {
                        for (int i = 0; i < ship.getValue(); i++) {
                            field[coordinate.get(coordinate.size() - 1) + i][coordinate.get(0) - 1] = HALO;
                        }
                    }
                    //рисуем ореол верхнему борту
                    if (coordinate.get(coordinate.size() - 1) - 1 >= 0) {
                        field[coordinate.get(coordinate.size() - 1) - 1][coordinate.get(0)] = HALO;
                    }
                    //рисуем ореол верхний-правый борт
                    if (coordinate.get(coordinate.size() - 1) - 1 >= 0 && coordinate.get(0) + 1 < 10) {
                        field[coordinate.get(coordinate.size() - 1) - 1][coordinate.get(0) + 1] = HALO;
                    }
                    //рисуем ореол верхний-левый борт
                    if (coordinate.get(coordinate.size() - 1) - 1 >= 0 && coordinate.get(0) - 1 >= 0) {
                        field[coordinate.get(coordinate.size() - 1) - 1][coordinate.get(0) - 1] = HALO;
                    }
                    //рисуем ореол нижнему борту
                    if (coordinate.get(1) + 1 < 10) {
                        field[coordinate.get(1) + 1][coordinate.get(0)] = HALO;
                    }
                    //рисуем ореол нижний правый борт
                    if (coordinate.get(1) + 1 < 10 && coordinate.get(0) + 1 < 10) {
                        field[coordinate.get(1) + 1][coordinate.get(0) + 1] = HALO;
                    }
                    //рисуем ореол нижний левый борт
                    if (coordinate.get(1) + 1 < 10 && coordinate.get(0) - 1 >= 0) {
                        field[coordinate.get(1) + 1][coordinate.get(0) - 1] = HALO;
                    }
                }
            } else {
                if (coordinate.get(0) < coordinate.get(2)) {
                    //рисуем ореол по правому борту
                    if (coordinate.get(coordinate.size() - 2) + 1 < 10) {
                        field[coordinate.get(1)][coordinate.get(coordinate.size() - 2) + 1] = HALO;
                    }
                    //рисуем ореол по левому борту
                    if (coordinate.get(0) - 1 >= 0) {
                        field[coordinate.get(1)][coordinate.get(0) - 1] = HALO;
                    }
                    //рисуем ореол верхнему борту
                    if (coordinate.get(1) - 1 >= 0) {
                        for (int i = 0; i < ship.getValue(); i++) {
                            field[coordinate.get(1) - 1][coordinate.get(0) + i] = HALO;
                        }
                    }
                    //рисуем ореол верхний-правый борт
                    if (coordinate.get(1) - 1 >= 0 && coordinate.get(coordinate.size() - 2) + 1 < 10) {
                        field[coordinate.get(1) - 1][coordinate.get(coordinate.size() - 2) + 1] = HALO;
                    }
                    //рисуем ореол верхний-левый борт
                    if (coordinate.get(1) - 1 >= 0 && coordinate.get(0) - 1 >= 0) {
                        field[coordinate.get(1) - 1][coordinate.get(0) - 1] = HALO;
                    }
                    //рисуем ореол нижнему борту
                    if (coordinate.get(1) + 1 < 10) {
                        for (int i = 0; i < ship.getValue(); i++) {
                            field[coordinate.get(1) + 1][coordinate.get(0) + i] = HALO;
                        }
                    }
                    //рисуем ореол нижний правый борт
                    if (coordinate.get(1) + 1 < 10 && coordinate.get(coordinate.size() - 2) + 1 < 10) {
                        field[coordinate.get(1) + 1][coordinate.get(coordinate.size() - 2) + 1] = HALO;
                    }
                    //рисуем ореол нижний левый борт
                    if (coordinate.get(1) + 1 < 10 && coordinate.get(0) - 1 >= 0) {
                        field[coordinate.get(1) + 1][coordinate.get(0) - 1] = HALO;
                    }
                } else {
                    //рисуем ореол по правому борту
                    if (coordinate.get(0) + 1 < 10) {
                        field[coordinate.get(1)][coordinate.get(0) + 1] = HALO;
                    }
                    //рисуем ореол по левому борту
                    if (coordinate.get(coordinate.size() - 2) - 1 >= 0) {
                        field[coordinate.get(1)][coordinate.get(coordinate.size() - 2) - 1] = HALO;
                    }
                    //рисуем ореол верхнему борту
                    if (coordinate.get(1) - 1 >= 0) {
                        for (int i = 0; i < ship.getValue(); i++) {
                            field[coordinate.get(1) - 1][coordinate.get(coordinate.size() - 2) + i] = HALO;
                        }
                    }
                    //рисуем ореол верхний-правый борт
                    if (coordinate.get(1) - 1 >= 0 && coordinate.get(0) + 1 < 10) {
                        field[coordinate.get(1) - 1][coordinate.get(0) + 1] = HALO;
                    }
                    //рисуем ореол верхний-левый борт
                    if (coordinate.get(1) - 1 >= 0 && coordinate.get(coordinate.size() - 2) - 1 >= 0) {
                        field[coordinate.get(1) - 1][coordinate.get(coordinate.size() - 2) - 1] = HALO;
                    }
                    //рисуем ореол нижнему борту
                    if (coordinate.get(1) + 1 < 10) {
                        for (int i = 0; i < ship.getValue(); i++) {
                            field[coordinate.get(1) + 1][coordinate.get(coordinate.size() - 2) + i] = HALO;
                        }
                    }
                    //рисуем ореол нижний правый борт
                    if (coordinate.get(1) + 1 < 10 && coordinate.get(0) + 1 < 10) {
                        field[coordinate.get(1) + 1][coordinate.get(0) + 1] = HALO;
                    }
                    //рисуем ореол нижний левый борт
                    if (coordinate.get(1) + 1 < 10 && coordinate.get(coordinate.size() - 2) - 1 >= 0) {

                        System.out.println(coordinate);
                        field[coordinate.get(1) + 1][coordinate.get(coordinate.size() - 2) - 1] = HALO;
                    }
                }
            }
        } else {
            //правый борт на однопалубном
            if (coordinate.get(0) + 1 < 10) {
                field[coordinate.get(1)][coordinate.get(0) + 1] = HALO;
            }
            //левый борт на однопалубном
            if (coordinate.get(0) - 1 >= 0) {
                field[coordinate.get(1)][coordinate.get(0) - 1] = HALO;
            }
            //верхний борт на однопалубном
            if (coordinate.get(1) - 1 >= 0) {
                field[coordinate.get(1) - 1][coordinate.get(0)] = HALO;
            }
            //верхний-правый борт на однопалубном
            if (coordinate.get(1) - 1 >= 0 && coordinate.get(0) + 1 < 10) {
                field[coordinate.get(1) - 1][coordinate.get(0) + 1] = HALO;
            }
            //верхний-левый борт на однопалубном
            if (coordinate.get(1) - 1 >= 0 && coordinate.get(0) - 1 >= 0) {
                field[coordinate.get(1) - 1][coordinate.get(0) - 1] = HALO;
            }
            //нижний борт на однопалубном
            if (coordinate.get(1) + 1 < 10) {
                field[coordinate.get(1) + 1][coordinate.get(0)] = HALO;
            }
            //нижний правый борт на однопалубном
            if (coordinate.get(1) + 1 < 10 && coordinate.get(0) + 1 < 10) {
                field[coordinate.get(1) + 1][coordinate.get(0) + 1] = HALO;
            }
            // нижний левый борт на однопалубном
            if (coordinate.get(1) + 1 < 10 && coordinate.get(0) - 1 >= 0) {
                field[coordinate.get(1) + 1][coordinate.get(0) - 1] = HALO;
            }
        }
    }

    //отрисовка кораблей на поле
    public static void drawShipInField(GameObject[][] field, List<Integer> coordinate, GameObject ship, boolean isVertical) {

        if (coordinate.size() > 2) {
            if (isVertical) {
                if (coordinate.get(1) < coordinate.get(3)) {
                    for (int i = 0; i < ship.getValue(); i++) {
                        field[coordinate.get(1) + i][coordinate.get(0)] = ship;
                    }
                } else {
                    for (int i = 0; i < ship.getValue(); i++) {
                        field[coordinate.get(1) - i][coordinate.get(0)] = ship;
                    }
                }
            } else {
                if (coordinate.get(0) < coordinate.get(2)) {
                    for (int i = 0; i < ship.getValue(); i++) {
                        field[coordinate.get(1)][coordinate.get(0) + i] = ship;
                    }
                } else {
                    for (int i = 0; i < ship.getValue(); i++) {
                        field[coordinate.get(1)][coordinate.get(0) - i] = ship;
                    }
                }
            }
        } else {
            field[coordinate.get(1)][coordinate.get(0)] = ship;
        }
    }

    public static boolean checkShotCondition(String coordinateShots) {
        if (coordinateShots.isEmpty()) {
            System.out.println("Координаты не могут быть пустыми!");
            return false;
        }
        try {

            int[] shot = getIntsCoordinate(coordinateShots);
            if (shot.length < 2) {
                return false;
            }
            if (!(shot[0] >= 0 && shot[0] < 10)) {
                System.out.println("Координаты выстрела по оси Х должны быть в пределах от 0 до 9");
                return false;
            }
            if (!(shot[1] >= 0 && shot[1] < 10)) {
                System.out.println("Координаты выстрела по оси Y должны быть в пределах от 0 до 9");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Координаты введены не правильно! Разделяй их через запятую, Не допускай пустого ввода и координаты могут быть только цифрами");
            return false;
        }
        return true;
    }

    public static int[] getIntsCoordinate(String coordinateShots) {
        String[] coordinates = coordinateShots.split(",");
        int[] shot;
        if (coordinates.length == 2) {
            shot = new int[coordinates.length];
            for (int i = 0; i < coordinates.length; i++) {
                shot[i] = Integer.parseInt(coordinates[i]);
            }
        } else {
            shot = new int[0];
            System.out.println("Должна быть одна координата по Х,У. Разделитель запятая!");
        }

        return shot;
    }

    public static boolean hitOnTheShip(SeaField field, int[] coordinateShot) {
        int x = coordinateShot[0];
        int y = coordinateShot[1];
        while (field.getBoard()[y][x].getValue() != 0) {
            x += 1;
            if (x > 9) {
                break;
            }
            if (field.getBoard()[y][x].getMeaning() == 1) {
                return false;
            }
        }
        x = coordinateShot[0];
        while (field.getBoard()[y][x].getValue() != 0) {
            x -= 1;
            if (x < 0) {
                break;
            }
            if (field.getBoard()[y][x].getMeaning() == 1) {
                return false;
            }
        }
        x = coordinateShot[0];
        while (field.getBoard()[y][x].getValue() != 0) {
            y += 1;
            if (y > 9) {
                break;
            }
            if (field.getBoard()[y][x].getMeaning() == 1) {
                return false;
            }
        }
        y = coordinateShot[1];
        while (field.getBoard()[y][x].getValue() != 0) {
            y -= 1;
            if (y < 0) {
                break;
            }
            if (field.getBoard()[y][x].getMeaning() == 1) {
                return false;
            }
        }
        return true;
    }
}
