package day5;

public class Car {
    private String model;
    private String color;
    private int yearOfIssue;
    private String carInfo = "Ваше авто: %s, цвет: %s, %d года выпуска\n";

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void getInfo() {
        System.out.printf(carInfo, model, color, yearOfIssue);
    }
}
