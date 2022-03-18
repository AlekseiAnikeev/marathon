package day4;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int count0 = 0;
        int sum0 = 0;
        int temp = 0;
        int[] numbers = new int[100];
        int[] counter0 = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }
        for(int number : numbers) {
            temp = number;
            if (max < temp) {
                max = temp;
            }
            if (min > temp) {
                min = temp;
            }
            if (number % 10 == 0) {
                counter0[count0] = number;
                sum0 += counter0[count0];
                count0++;
            }
        }
        System.out.println("наибольший элемент массива: " + max);
        System.out.println("наименьший элемент массива: " + min);
        System.out.println("количество элементов массива, оканчивающихся на 0: " + count0);
        System.out.println("сумма элементов массива, оканчивающихся на 0: " + sum0);
    }
}
