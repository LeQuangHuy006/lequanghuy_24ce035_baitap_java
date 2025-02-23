public class TestMain {
    public static void main(String[] args) {
    Account a1 = new Account("Tan Ah Teck",88,101); 
    System.out.println(a1);   // toString(); 
    Account a2 = new Account("A102", "Kumar"); // số dư mặc định 
    System.out.println(a2); // Các phương thức lấy dữ liệu kiểm tra 
    System.out.println("ID: " + a1.getId()); 
    System.out.println("Name: " + a1.getName()); 
    System.out.println("Số dư: " + a1.getBalance()); // Kiểm tra credit() và debit() 
    a1.credit(100); 
    System.out.println(a1); 
    a1.debit(50); 
    System.out.println(a1); 
    a1.debit(500);   // lỗi debit() 
    System.out.println(a1); // Kiểm tra chuyển() 
    a1.transferTo(a2, 100);   // toString() 
    System.out.println(a1); 
    System.out.println(a2); 
 } }
