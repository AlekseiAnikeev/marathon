package day12.task3;

public class MusicBand {
    private String name;
    private int year;

    public MusicBand (String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return "Группа: " + getName()
                + ", год создания: " + getYear();
    }
}
