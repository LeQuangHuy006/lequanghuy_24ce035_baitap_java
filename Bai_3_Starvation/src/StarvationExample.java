public class StarvationExample {
    public static void main(String[] args) {
        Thread highPriority = new Thread(() -> {
            while (true) {System.out.println("High priority thread running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Thread.yield();}
        });
        Thread lowPriority = new Thread(() -> {
            while (true) {System.out.println("Low priority thread running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        highPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        highPriority.start();
        lowPriority.start();
    }
}