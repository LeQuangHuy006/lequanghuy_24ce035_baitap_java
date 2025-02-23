package Bai37; 
public class TestGame {
    public static void main(String[] args) {
        // Tạo một quả bóng tại vị trí (10, 10, 0)
        Ball ball = new Ball(10, 10, 0);
        System.out.println("Initial Ball: " + ball);

        // Tạo một cầu thủ ở vị trí (5, 5)
        Player player1 = new Player(7, 5, 5);
        System.out.println(player1);

        // Kiểm tra khoảng cách và thử sút bóng
        player1.kick(ball);
        System.out.println("Ball after kick: " + ball);

        // Di chuyển cầu thủ đến gần bóng hơn
        player1.move(3, 3);
        System.out.println(player1);

        // Thử sút lại
        player1.kick(ball);
        System.out.println("Ball after second kick: " + ball);
    }
}
