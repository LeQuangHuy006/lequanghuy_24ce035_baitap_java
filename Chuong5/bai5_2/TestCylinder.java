package bai5_2;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cyl1 = new Cylinder(2.0, "yellow", 4.0);
        System.out.println(cyl1);
        System.out.println("Surface Area: " + cyl1.getSurfaceArea());
        System.out.println("Volume: " + cyl1.getVolume());
        
        cyl1.setHeight(5.0);
        cyl1.setRadius(3.0);
        cyl1.setColor("red");
        System.out.println(cyl1);
        System.out.println("Surface Area: " + cyl1.getSurfaceArea());
        System.out.println("Volume: " + cyl1.getVolume());
    }
}
