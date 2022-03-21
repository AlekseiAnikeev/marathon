package day8;

public class Task1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String number = "0";
        for (int i = 1; i <= 20000; i++) {

            number += " " + i;
        }
        System.out.println(number);
        long stopTime = System.currentTimeMillis();
        System.out.println("Длительность работы, в мс.: " + (stopTime - startTime));

        long startTime2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i <= 20000; i++) {
            sb.append(" ")
                    .append(i);
        }
        System.out.println(sb);
        long stopTime2 = System.currentTimeMillis();
        System.out.println("Длительность работы, в мс.: " + (stopTime2 - startTime2));
    }
}
