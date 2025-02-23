package bai25;

public class TestMain {
    public static void main(String[] args) {
        Customer c1 = new Customer(101, "John Doe", 'm');
        System.out.println(c1);

        Account acc1 = new Account(1001, c1, 500.0);
        System.out.println(acc1);

        acc1.deposit(150.0);
        System.out.println(acc1);

        acc1.withdraw(200.0);
        System.out.println(acc1);

        acc1.withdraw(600.0);
        System.out.println(acc1);
    }
}
