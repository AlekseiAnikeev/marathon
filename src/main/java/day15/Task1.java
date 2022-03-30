package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/shoes.csv");
        File outputFile = new File("src/main/resources/missing_shoes.txt");
        try (Scanner scanner = new Scanner(file); PrintWriter writer = new PrintWriter(outputFile)) {
            while (scanner.hasNextLine()) {
                String[] list = scanner.nextLine().split(";");
                if (list.length == 3) {
                    if (Integer.parseInt(list[2]) == 0)
                        writer.println(list[0] + ", " + list[1] + ", " + list[2]);
                } else throw new IllegalArgumentException("Ошибка входного файла, проверьте соответствие столбцов");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
