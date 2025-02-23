package bai1;
public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice", "Premium");
        Visit visit1 = new Visit(customer1);
        visit1.setServiceExpense(100);
        visit1.setProductExpense(50);
        System.out.println("Total bill for " + customer1.getName() + ": $" + visit1.getTotalExpense());
    }
}
