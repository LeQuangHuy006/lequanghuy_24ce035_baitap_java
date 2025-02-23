package Bai42;

public class TestMain {
    public static void main(String[] args) {
       
        Person person = new Person("John Doe", "123 Main St");
        System.out.println(person);

       
        Student student = new Student("Alice", "456 Elm St", "Computer Science", 2, 1500.0);
        System.out.println(student);

       
        Staff staff = new Staff("Bob", "789 Oak St", "XYZ School", 2000.0);
        System.out.println(staff);
    }
}
