package Bai36;
public class Container {
    private int x1, y1, x2, y2; 

  
    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }

    public int getX() { return x1; }
    public int getY() { return y1; }
    public int getWidth() { return x2 - x1; }
    public int getHeight() { return y2 - y1; }

   
    public void checkCollision(Ball ball) {
        float ballX = ball.getX();
        float ballY = ball.getY();
        int radius = ball.getRadius();

        if (ballX - radius <= x1 || ballX + radius >= x2) {
            ball.reflectHorizontal();
        }
        if (ballY - radius <= y1 || ballY + radius >= y2) {
            ball.reflectVertical();
        }
    }

   
    public String toString() {
        return "Container[(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")]";
    }

}
