package Bai33;
import java.util.Scanner;
import java.math.BigInteger;

public class TestBiInteger {
    public static void main(String[] args) {
   
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Nhap so thu nhat: ");
        BigInteger num1 = new BigInteger(scanner.nextLine());

      
        System.out.print("Nhap so thu hai: ");
        BigInteger num2 = new BigInteger(scanner.nextLine());

       
        BigInteger sum = num1.add(num2);
        System.out.println("Tong: " + sum);

       
        BigInteger product = num1.multiply(num2);
        System.out.println("Tich: " + product);

      
        scanner.close();
    }
}
