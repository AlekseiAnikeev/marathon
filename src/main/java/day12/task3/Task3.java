package day12.task3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        List<MusicBand> musicBand = new ArrayList<>(Arrays.asList(new MusicBand("Nautilus Pompilius", 1982),
                new MusicBand("Кино", 1981),
                new MusicBand("Сектор Газа", 1987),
                new MusicBand("Gorillaz", 1998),
                new MusicBand("Destrose", 2005),
                new MusicBand("Skillet", 1996),
                new MusicBand("Linkin Park", 1996),
                new MusicBand("Disturbed", 1994),
                new MusicBand("Radio Tapok", 2016),
                new MusicBand("MiyaGi & Andy Panda ", 2015)));
//        for (MusicBand ms : musicBand) { // как построчный вариант вывода
//            System.out.println(ms);
//        }
        System.out.println(musicBand); // вывод в одну строку
        Collections.shuffle(musicBand);
        musicBand = groupsAfter2000(musicBand);
        System.out.println(musicBand);
    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        List<MusicBand> list = new ArrayList<>();
        for (MusicBand musicBand : bands) {
            if (musicBand.getYear() >= 2000) {
                list.add(musicBand);
            }
        }
        return list;
    }
}
