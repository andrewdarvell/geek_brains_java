package catsplates;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (!satiety) {
            satiety = p.decreaseFood(appetite);
        }
    }

    public void printSatietyInfo() {
        System.out.printf("%s is satiety: %b%n", name, satiety);
    }
}
