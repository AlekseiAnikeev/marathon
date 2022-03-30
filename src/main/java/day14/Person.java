package day14;

public class Person {
    private String name;
    private String year;

    public Person(String name, String year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", year=" + year  +
                '}';
    }
}
