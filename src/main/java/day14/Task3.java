package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("people");
        System.out.println(parseFileToObjList(file));
    }

    public static List<Person> parseFileToObjList(File file) {
        List<Person> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String people = scanner.nextLine();
                String[] person = people.split(" ");
                if (Integer.parseInt(person[1]) > 0)
                    list.add(new Person(person[0], person[1]));
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
