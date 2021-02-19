package pets;

public class Cat extends Animal {

    public Cat(String name) {
        super(name, 200, 0);
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s %s не умеет плавать %n", getAnimalTypeString(), getName());
    }

    @Override
    public String getAnimalTypeString() {
        return "Кот";
    }
}
