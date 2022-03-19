package day6;

public class Task1 {
    public static void main(String[] args) {
        Car car = new Car();
        car.setModel("Vesta");
        car.setColor("Black");
        car.setYear(2022);
        car.info();
        System.out.println("Модель: " + car.getModel());
        System.out.println("Цвет: " + car.getColor());
        System.out.println("Год выпуска: " + car.getYear());
        int differenceCar = car.yearDifference(2020);
        System.out.println("Разница: " + differenceCar);

        Motorbike moto = new Motorbike("suzuki", "black", 2010);
        moto.info();
        System.out.println("Модель: " + moto.getModel());
        System.out.println("Цвет: " + moto.getColor());
        System.out.println("Год выпуска: " + moto.getYear());
        int differenceMoto = moto.yearDifference(2000);
        System.out.println("Разница: " + differenceMoto);
    }
}
