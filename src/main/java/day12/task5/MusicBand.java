package day12.task5;

import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<MusicArtist> member;

    public MusicBand(String name, int year, List<MusicArtist> member) {
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

    public List<MusicArtist> getMember() {
        return member;
    }

    public static void transferMembers(MusicBand a, MusicBand b) {
        for (MusicArtist member : a.getMember()) {
            b.getMember().add(member);
        }
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
