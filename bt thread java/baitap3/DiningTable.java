package baitap3;

import java.util.LinkedList;

class DiningTable {
    private final int CAPACITY = 5;
    private final LinkedList<String> table = new LinkedList<>();

    public synchronized void cook(String dish) throws InterruptedException {
        while (table.size() == CAPACITY) {
            System.out.println("Ban đay, đau bep đoi...");
            wait();
        }
        table.add(dish);
        System.out.println("dau bep nau: " + dish);
        notify();
    }

    public synchronized void eat() throws InterruptedException {
        while (table.isEmpty()) {
            System.out.println("Ban trong, khach hang doi...");
            wait();
        }
        String dish = table.removeFirst();
        System.out.println("Khach hang an: " + dish);
        notify();
    }
}
