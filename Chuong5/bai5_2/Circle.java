package bai5_2;

public class Circle {
        private double radius; // Bán kính
        private String color;  // Màu sắc
        
        // Constructor mặc định
        public Circle() {
            this.radius = 1.0;
            this.color = "red";
        }
        
        // Constructor có tham số
        public Circle(double radius, String color) {
            this.radius = radius;
            this.color = color;
        }
        
        // Các phương thức lấy giá trị
        public double getRadius() {
            return radius;
        }
        
        public String getColor() {
            return color;
        }
        
        // Các phương thức đặt giá trị
        public void setRadius(double radius) {
            this.radius = radius;
        }
        
        public void setColor(String color) {
            this.color = color;
        }
        
        // Phương thức tính diện tích
        public double getArea() {
            return Math.PI * radius * radius;
        }
        
        // Phương thức toString
        public String toString() {
            return "Circle[radius=" + radius + ",color=" + color + "]";
        }
    }
    

