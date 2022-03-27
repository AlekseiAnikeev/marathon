package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("people");
        List<String> list = parseFileToStringList(file);
        System.out.println(list);
    }

    public static List<String> parseFileToStringList(File file) {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String people = scanner.nextLine();
                String[] year = people.split(" ");
                if (Integer.parseInt(year[1]) > 0)
                    list.add(people);
                else throw new IllegalArgumentException();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Некорректный входной файл");
            return null;
        }
        return list;
    }
}
