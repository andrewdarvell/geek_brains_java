package pets;

public class Cat extends Animal {


    public Cat(String name, int maxRunDistance) {
        super(name, maxRunDistance, 0);
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
