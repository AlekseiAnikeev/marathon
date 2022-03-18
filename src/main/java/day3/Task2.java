package day3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dividend;
        double divider;
        while(true) {
            dividend = scanner.nextDouble();
            divider = scanner.nextDouble();

            if(divider == 0) {
                break;
            }
            System.out.println(dividend / divider);
        }
    }
}
