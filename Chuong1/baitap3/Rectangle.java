

public class Rectangle {
        private float length;
        private float width;
    
        public Rectangle(){
            length = 1;
            width = 1;
        }
    
        public Rectangle(float a,float b){
            length =a;
            width =b;
        }
    
        public float getLength() {
            return length;
        }
    
        public float getWidth() {
            return width;
        }
    
        public void setLength(float length) {
            this.length = length;
        }
    
        public void setWidth(float width) {
            this.width = width;
        }
        public double getArea(){
            return length*width;
        }
        public double getPerimeter(){
            return (length+width)*2;
        }
        public String toString(){
            return "[length="+length+",width="+width+"]";
        }
    }

