package pets;

public class AnimalStore {

    private Animal[] animals = new Animal[0];
    private int dogsCount = 0;
    private int catsCount = 0;


    public void addAnimals(Animal... animals) {
        Animal[] newAnimals = new Animal[this.animals.length + animals.length];

        for (int i = 0; i < this.animals.length; i++) {
            newAnimals[i] = this.animals[i];
        }

        for (int i = 0; i < animals.length; i++) {
            newAnimals[this.animals.length + i] = animals[i];
            if (animals[i] instanceof Cat) {
                catsCount++;
            } else if (animals[i] instanceof Dog) {
                dogsCount++;
            }
        }
        this.animals = newAnimals;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void printAnimalsStatistic() {
        System.out.println("Всего животных: " + animals.length);
        System.out.println("Котов: " + catsCount);
        System.out.println("Собак: " + dogsCount);
    }

}
