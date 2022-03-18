package day4;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] numbers = new int[12][8];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = random.nextInt(50);
//                System.out.print(numbers[i][j] + " ");
            }
//            System.out.println();
        }
        int maxSum = 0;
        int indexSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = 0; j < numbers[i].length; j++) {
                sum += numbers[i][j];
            }
            if (maxSum <= sum) {
                maxSum = sum;
                indexSum = i;
            }
        }
        System.out.println("Индекс максимальной суммы: " + indexSum);
    }
}
