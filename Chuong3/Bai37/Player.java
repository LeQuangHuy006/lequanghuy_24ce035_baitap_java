package Bai37;

public class Player {
    // Thuộc tính
    private int number;
    private float x;
    private float y;
    private float z = 0.0f; // Mặc định z = 0.0

    // Constructor
    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    // Phương thức di chuyển theo trục x, y
    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    // Phương thức nhảy theo trục z
    public void jump(float zDisp) {
        this.z += zDisp;
    }

    // Kiểm tra khoảng cách giữa Player và Ball
    public boolean near(Ball ball) {
        double distance = Math.sqrt(Math.pow(this.x - ball.getX(), 2) + Math.pow(this.y - ball.getY(), 2) + Math.pow(this.z - ball.getZ(), 2));
        return distance < 8;
    }

    // Phương thức sút bóng
    public void kick(Ball ball) {
        if (near(ball)) {
            ball.setXYZ(ball.getX() + 10, ball.getY() + 10, ball.getZ() + 5);
            System.out.println("Player " + number + " kicked the ball!");
        } else {
            System.out.println("Player " + number + " is too far to kick the ball.");
        }
    }

    // Phương thức toString để hiển thị thông tin Player
    @Override
    public String toString() {
        return "Player " + number + " at (" + x + "," + y + "," + z + ")";
    }
}
