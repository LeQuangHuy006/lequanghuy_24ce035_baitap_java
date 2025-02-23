package Bai37;

public class Ball {
    // Thuộc tính
    private float x;
    private float y;
    private float z;

    // Constructor
    public Ball(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getter
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    // Setter để thiết lập lại vị trí bóng
    public void setXYZ(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Phương thức toString để hiển thị thông tin bóng
    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
