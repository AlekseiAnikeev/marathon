package day11.task1;

public class Courier implements Worker{
    private double salary;
    private boolean isPayed;
    private Warehouse warehouse;
    public Courier(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isPayed() {
        return isPayed;
    }

    @Override
    public String toString() {
        return "Сборщики получили " +
                "зарплату равную: " + salary +
                (isPayed? ", бонус получен" : ", до бонуса не доросли");
    }

    @Override
    public void doWork() {
        this.salary += 100;
        this.warehouse.changeDeliveredOrders();
    }

    @Override
    public void bonus() {
        if(warehouse.getCountDeliveredOrders() < 10000) {
            System.out.println("Бонус пока не доступен");
            return;
        }

        if (isPayed) {
            System.out.println("Бонус уже был выплачен");
            return;
        }

        salary += 50000;
        isPayed = true;
    }
}
