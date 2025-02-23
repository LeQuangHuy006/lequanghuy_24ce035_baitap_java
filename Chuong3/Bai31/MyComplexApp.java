import java.util.Scanner;

import Bai31.MyComplex;

public class MyComplexApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.print("Nhap so phuc 1 (phan thuc va phan ao): ");
        double real1 = scanner.nextDouble();
        double imag1 = scanner.nextDouble();
        MyComplex c1 = new MyComplex(real1, imag1);

      
        System.out.print("Nhap so phuc 2 (phan thuc va phan ao): ");
        double real2 = scanner.nextDouble();
        double imag2 = scanner.nextDouble();
        MyComplex c2 = new MyComplex(real2, imag2);

      
        System.out.println("\nSo phuc 1: " + c1);
        System.out.println(c1 + (c1.isReal() ? " la so thuc" : " KHONG la so thuc"));
        System.out.println(c1 + (c1.isImaginary() ? " la so ao" : " KHONG la so ao"));

        System.out.println("\nSo phuc 2: " + c2);
        System.out.println(c2 + (c2.isReal() ? " la so thuc" : " KHONG la so thuc"));
        System.out.println(c2 + (c2.isImaginary() ? " la so ao" : " KHONG la so ao"));

    
        System.out.println("\n" + c1 + (c1.equals(c2) ? " bang " : " KHONG bang ") + c2);

     
        System.out.println("\n" + c1 + " + " + c2 + " = " + c1.addNew(c2));
        System.out.println(c1 + " - " + c2 + " = " + c1.subtractNew(c2));
        System.out.println(c1 + " * " + c2 + " = " + c1.multiply(new MyComplex(c2.getReal(), c2.getImag())));
        System.out.println(c1 + " / " + c2 + " = " + c1.divide(new MyComplex(c2.getReal(), c2.getImag())));
        System.out.println("Lien hop cua " + c1 + " = " + c1.conjugate());

        scanner.close();
    }
}
