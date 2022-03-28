package day12.task4;

import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<String> member;

    public MusicBand(String name, int year, List<String> member) {
        this.name = name;
        this.year = year;
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<String> getMember() {
        return member;
    }

    public static void transferMembers(MusicBand a, MusicBand b) {
        for (String member : a.getMember()) {
            b.getMember().add(member);
        }
        a.getMember().clear();
    }

    public void printMembers() {
        System.out.println(member);
    }

    public String toString() {
        return "Группа: " + getName()
                + ", год создания: " + getYear()
                + ", состав: " + member;
    }
}
