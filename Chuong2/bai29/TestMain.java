package bai29;
public class TestMain {
    public static void main(String[] args) {
        MyTriangle t1 = new MyTriangle(0, 0, 3, 0, 0, 4);
        MyTriangle t2 = new MyTriangle(new MyPoint(1, 1), new MyPoint(4, 1), new MyPoint(2, 3));

        System.out.println(t1);
        System.out.println("Perimeter is: " + t1.getPerimeter());
        System.out.println("Type: " + t1.getType());

        System.out.println(t2);
        System.out.println("Perimeter2 is: " + t2.getPerimeter());
        System.out.println("Type: " + t2.getType());
    }
}
