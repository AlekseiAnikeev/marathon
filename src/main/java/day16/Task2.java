package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Random rand = new Random();

        try (PrintWriter writer = new PrintWriter(file1)) {
            for (int i = 0; i < 1000; i++) {
                writer.print(rand.nextInt(101) + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(file1); PrintWriter writer = new PrintWriter(file2)) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int i = 0; i < numbers.length; i += 20) {
                int sum = 0;
                for (int j = i; j < i + 20; j++) {
                    sum += Integer.parseInt(numbers[j]);
                }
                writer.print(((double) sum / 20) + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        printResult(file2);
    }

    public static void printResult(File file) {
        double sum = 0;

        try (Scanner scanner = new Scanner(file)) {
            String[] numbers = scanner.nextLine().split(" ");
            for (String number : numbers) {
                sum += Double.parseDouble(number);
            }
            System.out.println((int) sum);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
