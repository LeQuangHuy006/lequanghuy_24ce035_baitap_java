package bai6_6;

public class TestAnimal {
    public static void main(String[] args) {
        Animal cat = new Cat("Kitty");
        cat.greets(); // Meow

        Dog dog1 = new Dog("Buddy");
        dog1.greets(); // Woof

        Dog dog2 = new Dog("Charlie");
        dog1.greets(dog2); // Woooof

        BigDog bigDog1 = new BigDog("Max");
        bigDog1.greets(); // Woow

        bigDog1.greets(dog1); // Wooooow

        BigDog bigDog2 = new BigDog("Rocky");
        bigDog1.greets(bigDog2); // Woooooooow
    }
}
