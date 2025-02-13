package baitap2
;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
        radius = 1;
        color = "red";
    }

    public Circle(double r){
        radius = r;
        color = "red";
    }

    public Circle (double r,String t){
        radius = r;
        color = t;
    }

    public String toString() {
        return "Circle[radius=" + radius +"]";
    }
    public double getCircumference(){
        return 2*Math.PI*radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }
}
