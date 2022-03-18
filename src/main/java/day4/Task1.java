package day4;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num8 = 0;
        int num1 = 0;
        int even = 0;
        int notEven = 0;
        int sum = 0;
        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }

        for (int number : numbers) {
            System.out.println(number);
            if (number > 8) num8++;
            if (number == 1) num1++;
            if (number % 2 == 0) even++;
            if (number % 2 != 0) notEven++;
            sum += number;

        }
        System.out.println("Длина массива: " + numbers.length);
        System.out.println("Количество чисел больше 8: " + num8);
        System.out.println("Количество чисел равных 1: " + num1);
        System.out.println("Количество четных чисел: " + even);
        System.out.println("Количество нечетных чисел: " + notEven);
        System.out.println("Сумма всех элементов массива: " + sum);

    }
}
