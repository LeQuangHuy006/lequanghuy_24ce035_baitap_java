package baitap9;

public class TestMain {

    public static void main(String[] args) {
        Ball ball = new Ball(1.1f, 2.2f, 10, 3.3f, 4.4f); 
      System.out.println(ball);   // toString() // Kiểm tra các phương thức thiết lập và lấy dữ liệu 
      ball.setx(80.0f); 
      ball.sety(35.0f); 
      ball.setRadius(5); 
      ball.setxDelta(4.0f); 
      ball.setyDelta(6.0f); 
      System.out.println(ball);   // toString() 
      System.out.println("x là: " + ball.getX()); 
      System.out.println("y là: " + ball.getY()); 
      System.out.println("bán kính là: " + ball.getRadius()); 
      System.out.println("xDelta là: " + ball.getxDelta()); 
      System.out.println("yDelta is: " + ball.getyDelta()); // Nảy bóng trong ranh giới 
      float xMin = 0.0f; 
      float xMax = 100.0f; 
      float yMin = 0.0f; 
      float yMax = 50.0f; 
      for (int i = 0; i < 15; i++) { 
         ball.move(); 
         System.out.println(ball); 
         float xNew = ball.getX(); 
         float yNew = ball.getY(); 
         int radius = ball.getRadius(); // Kiểm tra giá trị ranh giới để nảy trở lại 
         if ((xNew + radius) > xMax || (xNew - radius) < xMin) { 
            ball.reflectHorizontal(); 
         } 
         if ((yNew + radius) > yMax || (yNew - radius) < yMin) { 
            ball.reflectVertical(); 
         } 
      } 
}
}