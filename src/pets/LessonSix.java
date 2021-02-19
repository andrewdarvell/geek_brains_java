package pets;

public class LessonSix {

    public static void main(String[] args) {
        AnimalStore animalStore = new AnimalStore();

        animalStore.addAnimals(new Dog("Шарик", 323, 12)
                , new Dog("Бобик", 500, 10)
                , new Cat("Василий", 300)
        );

        animalStore.printAnimalsStatistic();

        animalStore.addAnimals(new Dog("Джульбарс", 900, 30)
                , new Dog("Артемон", 100, 4)
                , new Cat("Пельмень", 50)
                , new Cat("Ленивый", 10)
        );
        animalStore.printAnimalsStatistic();

        for (int i = 0; i < animalStore.getAnimals().length; i++) {
            animalStore.getAnimals()[i].run(872);
            animalStore.getAnimals()[i].run(300);
            animalStore.getAnimals()[i].run(155);
            animalStore.getAnimals()[i].run(12);
            animalStore.getAnimals()[i].run(5);
            animalStore.getAnimals()[i].swim(5);
            animalStore.getAnimals()[i].swim(11);
        }
    }
}
