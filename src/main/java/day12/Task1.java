package day12;

import java.lang.reflect.Array;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Ведровер", "Краз", "Лада", "ЛиАЗ", "Газ"));
        System.out.println(list);
        list.add(2, "АЗЛК");
        list.remove(0);
        System.out.println(list);
    }
}
