package bai28;

public class TestMain {
    public static void main(String[] args) {
        MyCircle c1 = new MyCircle(3, 4, 5);
        MyCircle c2 = new MyCircle(new MyPoint(10, 10), 7);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println("Area is: " + c1.getArea());
        System.out.println("Circumference is: " + c1.getCircumference());
        System.out.println("Distance is: " + c1.distance(c2));
    }
}
