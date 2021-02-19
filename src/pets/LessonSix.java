package pets;

public class LessonSix {

    public static void main(String[] args) {
        AnimalStore animalStore = new AnimalStore();

        animalStore.addAnimals(new Dog("Шарик")
                , new Dog("Бобик")
                , new Cat("Василий")
        );

        animalStore.printAnimalsStatistic();

        animalStore.addAnimals(new Dog("Джульбарс")
                , new Dog("Артемон")
                , new Cat("Пельмень")
                , new Cat("Ленивый")
        );
        animalStore.printAnimalsStatistic();

        for (int i = 0; i < animalStore.getAnimals().length; i++) {
            animalStore.getAnimals()[i].run(872);
            animalStore.getAnimals()[i].run(300);
            animalStore.getAnimals()[i].run(155);
            animalStore.getAnimals()[i].swim(5);
            animalStore.getAnimals()[i].swim(11);
        }
    }
}
