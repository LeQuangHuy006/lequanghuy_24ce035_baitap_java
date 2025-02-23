package Bai34;

public class TestMain {
    public static void main(String[] args) {
     
        MyTime time = new MyTime(23, 59, 59);
        System.out.println("Thoi gian hien tai: " + time);

       
        time.nextSecond();
        System.out.println("Sau 1 giay: " + time);

       
        time.previousSecond();
        System.out.println("Truoc 1 giay: " + time);

       
        time.nextMinute();
        System.out.println("Sau 1 phut: " + time);

        
        time.previousMinute();
        System.out.println("Truoc 1 phut: " + time);

      
        time.nextHour();
        System.out.println("Sau 1 gio: " + time);

       
        time.previousHour();
        System.out.println("Truoc 1 gio: " + time);
    }
}
