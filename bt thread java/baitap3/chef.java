package baitap3;

class Chef extends Thread {
    private final DiningTable table;
    private int dishNumber = 1;

    public Chef(DiningTable table) {
        this.table = table;
    }

    public void run() {
        try {
            while (true) {
                table.cook("Mon " + dishNumber++);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}