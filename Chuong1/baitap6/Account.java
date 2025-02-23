

public class Account {

    private String name;
    private double balance  ;
    private String id;
    public Account(String name , String id) {
        this.name = name;
        this.id = id;
        this.balance = 0.0;

    }    
    public Account(String name, double balance, String id)
     {
        this.name = name;
        this.balance = balance;
        this.id = String.valueOf(id);
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return (int) balance;
    }
    public String getId() {
        return id;
    }
    public void credit(double amount) {
        if (amount > 0){
            balance += amount;
        System.out.println("nap thanh cong"+ amount);}
        else {
            System.out.println("nap khong thanh cong");
        }

    }
    public void debit(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rút thành công: " + amount);
        } else {
            System.out.println("Số dư không đủ hoặc số tiền rút không hợp lệ!");
        }
        public void transferTo(Account another, double amount) {
            if (amount > 0 && amount <= balance) {
                this.balance -= amount;
                another.balance += amount;
                System.out.println("Chuyển thành công " + amount + " đến tài khoản: " + another.getId());
            } else {
                System.out.println("Chuyển khoản thất bại! Kiểm tra số dư hoặc số tiền hợp lệ.");
            }
        }
    
        public String toString() {
            return "Name: " + name + ", ID: " + id + ", Balance: " + balance;
        }
    
}
