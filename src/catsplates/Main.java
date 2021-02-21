package catsplates;

public class Main {

    public static void main(String[] args) {
        Plate plate = new Plate(15);
        plate.info();

        Cat[] cats = {
                new Cat("Barsik", 5)
                , new Cat("Murzik", 10)
                , new Cat("Matroskin", 5)
        };

        System.out.println("*Feed cats");
        feedCats(cats, plate);
        plate.info();
        printCatsInfo(cats);

        System.out.println();
        plate.addFood(20);
        System.out.println("*Feed cats");
        feedCats(cats, plate);
        plate.info();
        printCatsInfo(cats);

    }

    static void feedCats(Cat[] cats, Plate plate) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }
    }

    static void printCatsInfo(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].printSatietyInfo();
        }
    }

}
