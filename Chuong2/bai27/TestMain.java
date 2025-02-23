package bai27;

public class TestMain {
    public static void main(String[] args) {
       
        MyPoint p1 = new MyPoint(1, 2);
        MyPoint p2 = new MyPoint(4, 6);

       
        MyLine line1 = new MyLine(p1, p2);
        System.out.println("Line1: " + line1);

      
        MyLine line2 = new MyLine(0, 0, 3, 4);
        System.out.println("Line2: " + line2);

      
        System.out.println("Length of line1: " + line1.getLength());
        System.out.println("Gradient of line1 (radian): " + line1.getGradient());

        System.out.println("Length of line2: " + line2.getLength());
        System.out.println("Gradient of line2 (radian): " + line2.getGradient());
    }
}
