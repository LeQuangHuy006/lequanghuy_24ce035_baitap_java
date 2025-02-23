package Bai44;

public class TestMovablePoint {
    public static void main(String[] args) {
       
        Point p = new Point(3.0f, 4.0f);
        System.out.println("Point: " + p);

      
        MovablePoint mp = new MovablePoint(3.0f, 4.0f, 1.5f, 2.5f);
        System.out.println("MovablePoint: " + mp);

       
        mp.setSpeed(2.0f, 3.0f);
        System.out.println("Updated Speed: " + java.util.Arrays.toString(mp.getSpeed()));

        
        mp.move();
        System.out.println("After Move: " + mp);

       
        mp.move();
        System.out.println("After Another Move: " + mp);
    }
}