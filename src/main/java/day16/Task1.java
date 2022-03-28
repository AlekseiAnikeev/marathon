package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("test");
        printResult(file);
    }

    public static void printResult(File file) {
        int sum = 0;
        double result = 0;
        try (Scanner scanner = new Scanner(file)) {
            String[] numbers = scanner.nextLine().split(" ");
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
            result = (double) sum / numbers.length;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.printf(result + " --> " + "%.3f", result);
    }
}
