package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/dushi.txt");
        Map<String, Integer> map = new HashMap<>();

        int countChichikov = 0; //Чичиков упомянут 772 раза с учетом скланений, либо 608 без)

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("[.,“:<>«;»…()?!\"\\s–]+");
            while (scanner.hasNext()) {
                String text = scanner.next();
                Integer counter = map.get(text);
                if (map.containsKey(text)) {
                    map.put(text, counter + 1);
                } else {
                    map.put(text, 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith("Чичиков")) countChichikov += entry.getValue();
        }

        System.out.println("Если исключить все косяки текста, то Чичиков упоминается " + countChichikov + " раз.");

        for (int i = 0; i < 100; i++) {
            Integer value = Collections.max(map.values());
            String key = null;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(value)) {
                    key = entry.getKey();
                }
            }
            System.out.println(key + " " + value);
            if (key != null)
                map.remove(key);
        }
    }
}

