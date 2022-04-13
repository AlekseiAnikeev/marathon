package seaBattle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormatValidation {

    private static boolean isVertical = true;

    public static boolean isVertical() {
        return isVertical;
    }

    public List<Integer> addCoordinates(Scanner scanner, GameObject ship) {
        List<Integer> coordinate = new ArrayList<>();

        //       boolean punctuationOk = false;
        boolean numberInputOk = false;
        boolean integrityOk = false;
        try {
            String line = scanner.nextLine();
            String[] lineSplit = line.split("[,;]");

            if (lineSplit.length != ship.getValue() * 2 || line.isEmpty()) {
                throw new IllegalArgumentException("Не корректный ввод координат, должно быть " + ship.getValue() + " пары координат разделенных , и ;!");
            }
            for (String s : lineSplit) {
                if ((Integer.parseInt(s) >= 0 && Integer.parseInt(s) < 10)) {
                    numberInputOk = true;
                } else {
                    throw new IllegalArgumentException("Координаты должны быть от 0 до 9! попробуй снова!");
                }
            }

//            for (int i = 0; i < line.length(); i++) {
//                if (i == 1 || i == 5 || i == 9 || i == 13) {
//                    if (line.charAt(i) != ',') {
//                        throw new IllegalArgumentException(" j j j ");
//                    }
//                }
//                if (i == 3 || i == 7 || i == 11) {
//                    if (line.charAt(i) != ';') {
//                        System.out.println("Не корректный разделитель между координат X,Y , требуется делить координаты через \";\"");
//                        break;
//                    }
//                }
//                // если итерации дошли до конца то с пунктуацией все ок
//                if (i == line.length() - 1) {
//                    punctuationOk = true;
//                }
//            }
            // вызываем метод на проверку целостности корпуса
            if (ship.getValue() > 1)
                integrityOk = integrityShip(ship, lineSplit);
            //однопалубный проверять не надо
            if (ship.getValue() == 1)
                integrityOk = true;

            //если все ок возвратим координаты
            if (numberInputOk && integrityOk) {
                for (String s : lineSplit) {
                    coordinate.add(Integer.parseInt(s));
                }
                scanner.reset();
            }
        } catch (NumberFormatException e) {
            System.out.println("Убедись в том что: \n" +
                    "1. Ввод не пустой \n" +
                    "2. Введены только цифры и разделители!\n" +
                    "2. Введен корректный разделитель координат X и Y, требуется знак запятой!\n" +
                    "3. Введен корректный разделитель координат X и Y, требуется делить координаты через \";\"");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return coordinate;
    }

    //метод проверки целостности корабля
    private boolean integrityShip(GameObject ship, String[] lineSplit) {
        boolean xOk = false;
        boolean yOk = false;
        int[] arrayX = new int[ship.getValue()];
        int[] arrayY = new int[ship.getValue()];

        for (int i = 0, j = 0; i < arrayX.length; i++, j += 2) {
            arrayX[i] = Integer.parseInt(lineSplit[j]);
        }

        for (int i = 1, j = 1; i <= arrayY.length; i++, j += 2) {
            arrayY[i - 1] = Integer.parseInt(lineSplit[j]);
        }
        //проверка на то что все координаты по оси х одинаковы
        for (int i = 1; i < arrayX.length; i++) {
            if (arrayX[i - 1] == arrayX[i]) {
                xOk = true;
            } else {
                xOk = false;
                break;
            }
        }
        //проверка на то что все координаты по оси У одинаковы
        for (int i = 1; i < arrayY.length; i++) {
            if (arrayY[i - 1] == arrayY[i]) {
                yOk = true;
            } else {
                yOk = false;
                break;
            }
        }
        // если обе координаты Х и У не последовательны!!! не надо делать корабли!!!
        if (xOk && yOk) {
            System.out.println("Не верный ввод координат, одна из осей (Х или У) обязана иметь последовательность ввода типа (0,1,2...9)");
            return false;
        }
        //проверка положения корабля
        isVertical = xOk;
        boolean isAscendingX = arrayX[0] < arrayX[1];
        boolean isAscendingY = arrayY[0] < arrayY[1];

        // проверка в зависимости от кол-вoа палуб (3 или 4 палубы) последовательности ввода по оси х

        if (!(!xOk && !yOk)) {
            System.out.println("1");

            if (!xOk) {
                for (int i = 0; i < arrayX.length - 1; i++) {
                    int coordinateShip = arrayX[i + 1] - arrayX[i];
                    if (isAscendingX) {
                        if (coordinateShip != 1) {
                            System.out.println("Корабль должен быть литым, вводи координаты последовательно!(0,1,2,3....9 либо 9,8,7...0) по оси Х");
                            return false;
                        }
                    } else {
                        if (coordinateShip != -1) {
                            System.out.println("Корабль должен быть литым, вводи координаты последовательно!(0,1,2,3....9 либо 9,8,7...0) по оси Х");
                            return false;
                        }
                    }
                }
            }
            if (!yOk) {
                for (int i = 0; i < arrayY.length - 1; i++) {
                    int coordinateShip = arrayY[i + 1] - arrayY[i];
                    if (isAscendingY) {
                        if (coordinateShip != 1) {
                            System.out.println("Корабль должен быть литым, вводи координаты последовательно!(0,1,2,3....9 либо 9,8,7...0) по оси Y");
                            return false;
                        }
                    } else {
                        if (coordinateShip != -1) {
                            System.out.println("Корабль должен быть литым, вводи координаты последовательно!(0,1,2,3....9 либо 9,8,7...0) по оси Y");
                            return false;
                        }
                    }
                }
            }
        } else {
            System.out.println("По диагонали ставить корабли не честно :)");
            return false;
        }

        return true;
    }
}

