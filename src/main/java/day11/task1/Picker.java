package day11.task1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Picker implements Worker {
    private double salary;
    private boolean isPayed;
    private Warehouse warehouse;

    public Picker(Warehouse warehouse) {
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
        this.salary += 80;
        warehouse.changePickedOrders();
    }

    @Override
    public void bonus() {
        if (warehouse.getCountPickedOrders() < 10000) {
            System.out.println("Бонус пока не доступен");
            return;
        }

        if (isPayed) {
            System.out.println("Бонус уже был выплачен");
            return;
        }
        salary += 70000;
        isPayed = true;
    }
}
