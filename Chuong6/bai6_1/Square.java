package bai6_1;

    public class Square extends Rectangle {
    
        public Square() {
            super();
        }
        
        public Square(double side) {
            super(side, side);
        }
        
        public Square(double side, String color, boolean filled) {
            super(side, side, color, filled);
        }
        
        public double getSide() {
            return super.getWidth();
        }
        
        public void setSide(double side) {
            super.setWidth(side);
            super.setLength(side);
        }
        
        @Override
        public void setWidth(double width) {
            setSide(width);
        }
        
        @Override
        public void setLength(double length) {
            setSide(length);
        }
        
        @Override
        public String toString() {
            return "Square[Rectangle[Shape[color=" + color + ", filled=" + filled + "], side=" + getSide() + "]]";
        }
    }
    
