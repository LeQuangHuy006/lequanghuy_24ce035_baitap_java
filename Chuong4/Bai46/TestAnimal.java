package Bai46;

public class TestAnimal {
    public static void main(String[] args) {
        Animal a1 = new Animal("Generic Animal");
        System.out.println(a1);

        Mammal m1 = new Mammal("Generic Mammal");
        System.out.println(m1);

        Cat c1 = new Cat("Kitty");
        System.out.println(c1);
        c1.greets();

        Dog d1 = new Dog("Buddy");
        System.out.println(d1);
        d1.greets();

        Dog d2 = new Dog("Max");
        d1.greets(d2);
    }
}
