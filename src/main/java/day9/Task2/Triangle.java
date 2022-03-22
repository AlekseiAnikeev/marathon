package day9.Task2;

public class Triangle extends Figure {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC, String color) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt((p * (p - sideA) * (p - sideB) * (p - sideC)));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }
}
