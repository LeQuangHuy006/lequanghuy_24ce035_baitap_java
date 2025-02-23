package bai6_4;

public class TestMovable {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 2, 3);
        System.out.println("Initial Position of Point: " + point);
        point.moveUp();
        System.out.println("After moveUp: " + point);

        MovableCircle circle = new MovableCircle(5, 5, 2, 2, 10);
        System.out.println("\nInitial Position of Circle: " + circle);
        circle.moveLeft();
        System.out.println("After moveLeft: " + circle);
    }
}
