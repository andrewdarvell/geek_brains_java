package pets;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, 500, 10);
    }

    @Override
    public String getAnimalTypeString() {
        return "Собака";
    }
}
