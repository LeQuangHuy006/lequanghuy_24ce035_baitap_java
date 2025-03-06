package baitap3;

class Customer extends Thread {
    private final DiningTable table;

    public Customer(DiningTable table) {
        this.table = table;
    }

    public void run() {
        try {
            while (true) {
                table.eat();
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

