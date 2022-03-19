package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane airplane = new Airplane("Сухой", 2010, 35200, 5000);
        airplane.setYear(2012);
        airplane.setLength(5150);
        airplane.fillUp(22);
        airplane.fillUp(44);
        airplane.info();
    }
}
