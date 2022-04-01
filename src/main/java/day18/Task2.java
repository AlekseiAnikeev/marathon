package day18;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(717771237));
    }

    public static int count7(int numbers) {
        if (numbers == 0) return 0;

        if (numbers % 10 == 7) return 1 + count7(numbers / 10);
        else return count7(numbers / 10);

    }
}
