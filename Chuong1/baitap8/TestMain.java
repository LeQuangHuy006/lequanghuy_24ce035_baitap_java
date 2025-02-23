package baitap8;

public class TestMain {
    public static void main(String[] args) { // Kiểm tra các hàm tạo và toString() 
        Time t1 = new Time(1, 2, 3); 
        System.out.println(t1);   // toString() // Kiểm tra các hàm thiết lập và lấy thông tin 
        t1.setHour(4); 
        t1.setMinute(5); 
        t1.setSecond(6); 
        System.out.println(t1);   // toString() 
        System.out.println("Giờ: " + t1.getHour()); 
        System.out.println("Phút: " + t1.getMinute()); 
        System.out.println("Giây: " + t1.getSecond()); // Kiểm tra setTime() 
        t1.setTime(23, 59, 58); 
        t1.nextSecond();
        System.out.println(t1); // 23:59:59

        t1.nextSecond();
        System.out.println(t1); // 00:00:00

        t1.nextSecond();
        System.out.println(t1); // 00:00:01

        t1.previousSecond();
        System.out.println(t1); // 00:00:00

        t1.previousSecond();
        System.out.println(t1); // 23:59:59

        t1.previousSecond();
        System.out.println(t1); // 23:59:58 
     } 
}
