package day5;


public class Task2 {
    public static void main(String[] args) {
        Motorbike moto = new Motorbike("Suzuki_Bandit", "Black_Metal", 1992);
        System.out.println(moto.getModel());
        System.out.println(moto.getColor());
        System.out.println(moto.getYearOfIssue());
    }
}
