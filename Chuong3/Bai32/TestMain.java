package Bai32;

public class TestMain {
    public static void main(String[] args) {
        MyPolynomial p1 = new MyPolynomial(1, 2, 3); 
        MyPolynomial p2 = new MyPolynomial(3, 4, 5);

        System.out.println("Da thuc 1: " + p1);  
        System.out.println("Da thuc 2: " + p2);

        System.out.println("Bac cua da thuc 1: " + p1.getDegree());
        System.out.println("Gia tri p1 tai x = 2: " + p1.evaluate(2));

        MyPolynomial sum = p1.add(p2);
        System.out.println("Tong p1 + p2: " + sum);

        MyPolynomial product = p1.multiply(p2);
        System.out.println("Tich p1 * p2: " + product);
    }
}