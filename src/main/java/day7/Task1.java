package day7;

public class Task1 {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("Ty-160", 2017, 47368, 275000);
        Airplane airplane2 = new Airplane("B1-B", 1988, 44810, 216365);
        Airplane.compareAirplanes(airplane1,airplane2);
    }
}