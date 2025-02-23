

public class Employee {

    private String firstName;
    private String lastName;
    private int id;
    private int salary;
    public Employee(String firstName, String lastName, int id, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
    return id;}
    public String getFirstName() {
    return firstName;}
    public String getLastName() {
    return lastName;}
    public String getName() {
        return firstName + " " + lastName;
    }
    public int getSalary() {
    return salary;}
    public void setSalary(int salary) {
    this.salary = salary;
    }
    public int getAnnualSalary() {
    return salary*12;
    }
    public int raiseSalary (int percent) {
    return salary + (salary*percent/100);
}
    public String toString() {
        return "Employee [Name=" + firstName + lastName + ", id=" + id + ", salary=" + salary + "]";

}
}