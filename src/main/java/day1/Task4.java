package day1;

public class Task4 {
    public static void main(String[] args) {
        int year = 1980;
        while (year <= 2020) {
            System.out.printf("Олимпиада %s года\n", year);
            year += 4;
        }
    }
}