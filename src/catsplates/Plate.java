package catsplates;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public boolean decreaseFood(int n) {
        if (food - n >= 0) {
            food -= n;
            return true;
        }
        return false;
    }

    public void addFood(int n) {
        this.food += n;
    }

}
