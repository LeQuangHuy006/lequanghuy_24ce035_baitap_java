

public class TestMain {

    public static void main(String[] args) {
        Employee e1 = new Employee("Tan", "Peter", 8, 2500); 
        System.out.println(e1);   // toString(); // Kiểm tra các Setter và Getter 
        e1.setSalary(999); 
        System.out.println(e1);   // toString(); 
        System.out.println("id là: " + e1.getId()); 
        System.out.println("firstname là: " + e1.getFirstName()); 
        System.out.println("lastname là: " + e1.getLastName()); 
        System.out.println("salary là: " + e1.getSalary( )); 
        System.out.println("name là: " + e1.getName()); 
        System.out.println("annual salary là: " + e1.getAnnualSalary()); // Phương thức kiểm tra // Kiểm tra raiseSalary() 
        System.out.println(e1.raiseSalary(10)); 
        System.out.println(e1); 
     } 
}
