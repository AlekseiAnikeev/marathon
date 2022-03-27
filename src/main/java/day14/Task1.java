package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("test");
        printSumDigits(file);
    }

    public static void printSumDigits(File file) {
        int sum = 0;
        try (Scanner scanner = new Scanner(file)) {
            String[] digits = scanner.nextLine().split(" ");
            if (digits.length != 10) throw new IOException();
            for (String digit : digits) {
                sum += Integer.parseInt(digit);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Некорректный входной файл");
        }
        System.out.println(sum);
    }
}
