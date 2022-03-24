package day11.task1;

import java.util.concurrent.CountDownLatch;

public class Task1 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Warehouse warehouse2 = new Warehouse();
        Courier courier = new Courier(warehouse);
        Picker picker = new Picker(warehouse);
        Picker picker2 = new Picker(warehouse2);
        Courier courier2 = new Courier(warehouse2);
        picker2.doWork();
        courier2.doWork();

        businessProcess(picker);
        businessProcess(courier);
        System.out.println("Собрано: " + warehouse.getCountPickedOrders() + " товаров");
        System.out.println("Доставленно: " + warehouse.getCountDeliveredOrders() + " товаров");
        System.out.println(picker);
        System.out.println(courier);

        System.out.println("Собрано: " + warehouse2.getCountPickedOrders() + " товаров");
        System.out.println("Доставленно: " + warehouse2.getCountDeliveredOrders() + " товаров");
        System.out.println(picker2);
        System.out.println(courier2);

    }
    static void businessProcess(Worker worker) {
        for (int i = 0; i < 10000; i++) {
            worker.doWork();
        }
        worker.bonus();
    }
}
