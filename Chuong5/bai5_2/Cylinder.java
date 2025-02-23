package bai5_2;

public class Cylinder {
   
        private Circle base;  // Đối tượng Circle làm cơ sở
        private double height; // Chiều cao
        
        // Constructor mặc định
        public Cylinder() {
            base = new Circle(); // Gọi constructor của Circle
            height = 1.0;
        }
        
        // Constructor có tham số
        public Cylinder(double radius, String color, double height) {
            base = new Circle(radius, color);
            this.height = height;
        }
        
        // Phương thức lấy giá trị chiều cao
        public double getHeight() {
            return height;
        }
        
        // Phương thức đặt giá trị chiều cao
        public void setHeight(double height) {
            this.height = height;
        }
        
        // Phương thức lấy giá trị bán kính
        public double getRadius() {
            return base.getRadius();
        }
        
        // Phương thức lấy giá trị màu sắc
        public String getColor() {
            return base.getColor();
        }
        
        // Phương thức đặt giá trị bán kính
        public void setRadius(double radius) {
            base.setRadius(radius);
        }
        
        // Phương thức đặt giá trị màu sắc
        public void setColor(String color) {
            base.setColor(color);
        }
        
        // Phương thức tính diện tích bề mặt
        public double getSurfaceArea() {
            return 2 * Math.PI * base.getRadius() * height + 2 * base.getArea();
        }
        
        // Phương thức tính thể tích
        public double getVolume() {
            return base.getArea() * height;
        }
        
        // Phương thức toString
        public String toString() {
            return "Cylinder[base=" + base + ",height=" + height + "]";
        }
    }
    

