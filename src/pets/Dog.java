package pets;

public class Dog extends Animal {


    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
    }

    @Override
    public String getAnimalTypeString() {
        return "Собака";
    }
}
