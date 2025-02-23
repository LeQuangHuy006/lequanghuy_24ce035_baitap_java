package Bai45;

public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Circle(5.5, "blue", false);
        System.out.println(s1);
        
        Rectangle r1 = new Rectangle(2.0, 4.0, "yellow", true);
        System.out.println(r1);
        
        Square sq1 = new Square(3.0, "green", false);
        System.out.println(sq1);
    }
}
