package bai5_2;

public class TestCircle {
    
        public static void main(String[] args) {
            Circle c1 = new Circle(2.0, "blue");
            System.out.println(c1);
            System.out.println("Area: " + c1.getArea());
            
            c1.setRadius(3.0);
            c1.setColor("green");
            System.out.println(c1);
            System.out.println("Area: " + c1.getArea());
        }
    }
    

