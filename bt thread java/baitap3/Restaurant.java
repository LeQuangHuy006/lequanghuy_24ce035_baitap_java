package baitap3;

public class Restaurant {
    public static void main(String[] args) {
        DiningTable table = new DiningTable();
        new Chef(table).start();
        new Customer(table).start();
    }
}
