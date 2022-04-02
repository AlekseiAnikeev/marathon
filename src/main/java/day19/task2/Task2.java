package day19.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/taxi_cars.txt");
        int[][] board = new int[100][100];
        HashMap<Integer, Point> taxi = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] temp = scanner.nextLine().split(" ");
                if (temp.length != 3)
                    throw new IllegalArgumentException("Не корректный входной файл");
                taxi.put(Integer.parseInt(temp[0]), new Point(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        for (Map.Entry<Integer, Point> entry : taxi.entrySet()) {
            board[entry.getValue().getX()][entry.getValue().getY()] = entry.getKey();
        }
        printArray(board);
        carCounting(inputBoard(board));
    }

        private static int[][] inputBoard(int[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кординаты области поиска машины в формате: xFrom ,yFrom, xTo, yTo");
        int xFrom = scanner.nextInt();
        int yFrom = scanner.nextInt();
        int xTo = scanner.nextInt();
        int yTo = scanner.nextInt();

        int[][] result = new int[yTo - yFrom][xTo - xFrom];
        for (int i = yFrom; i < yTo; i++) {
            if (xTo - xFrom >= 0) System.arraycopy(board[i], xFrom, result[i - yFrom], 0, xTo - xFrom);
        }
        return result;
    }

    private static void carCounting(int[][] car) {
        List<Integer> idTaxi = new ArrayList<>();
        for (int[] taxi : car) {
            for (int i : taxi) {
                if (i != 0) {
                    idTaxi.add(i);
                }
            }
        }
        System.out.println("Всего автомобилей в зоне поиска: " + idTaxi.size());
        System.out.println("Найдены автомобили с id : ");
        System.out.println(idTaxi);
    }

    private static void printArray(int[][] array) {
        for (int[] x : array) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
