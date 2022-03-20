package day7;

public class Airplane {
    private String manufacturer;
    private int year;
    private int length;
    private int weight;
    private int fuel;
    private String infoAirplane = "Изготовитель: %s, год выпуска: %d, длина: %d, вес: %d, количество топлива в баке: %d\n";

    public Airplane(String manufacturer, int year, int length, int weight) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.length = length;
        this.weight = weight;
        this.fuel = 0;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void info() {
        System.out.printf(infoAirplane, manufacturer, year, length, weight, fuel);
    }

    public void fillUp(int n) {
        this.fuel += n;
    }

    public static void compareAirplanes(Airplane a, Airplane b) {
        if (a.length != b.length) {
            System.out.println(a.length > b.length ? "Первый самолет длиннее" : "Второй самолет длиннее");
        } else {
            System.out.println("Длины самолетов равны");
        }
    }
}
