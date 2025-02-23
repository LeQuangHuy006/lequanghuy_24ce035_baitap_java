package Bai43;

public class TestMain {
    public static void main(String[] args) {
        
        Point2D p2d = new Point2D(3.5f, 4.5f);
        System.out.println("Point2D: " + p2d);
        System.out.println("Array of x, y: " + java.util.Arrays.toString(p2d.getXY()));

        
        Point3D p3d = new Point3D(1.2f, 3.4f, 5.6f);
        System.out.println("Point3D: " + p3d);
        System.out.println("Array of x, y, z: " + java.util.Arrays.toString(p3d.getXYZ()));

       
        p3d.setXYZ(7.8f, 9.0f, 2.1f);
        System.out.println("Updated Point3D: " + p3d);
    } 
}
