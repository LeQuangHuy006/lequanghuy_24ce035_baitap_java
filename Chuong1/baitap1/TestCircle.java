
public class TestCircle extends Circle {
   public static void main(String[] args) {  
       Circle c1 = new Circle(); 
       System.out.println("Hình tròn có bán kính là " 
           + c1.getRadius() + ", diện tích là " + c1.getArea() 
           + " và màu sắc là " + c1.getColor());

       Circle c2 = new Circle(2.0); 
       System.out.println("Hình tròn có bán kính là " 
           + c2.getRadius() + ", diện tích là " + c2.getArea() 
           + " và màu sắc là " + c2.getColor());
   } 
}
