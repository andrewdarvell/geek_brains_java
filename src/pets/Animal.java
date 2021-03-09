package pets;

public abstract class Animal {

    public static final String RUN_ACTION_NAME = "Пробежал";
    public static final String SWIM_ACTION_NAME = "Проплыл";

    private final String name;
    private final int maxRunDistance;
    private final int maxSwimDistance;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    public String getName() {
        return name;
    }

    public abstract String getAnimalTypeString();

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public void run(int distance) {
        movingAction(RUN_ACTION_NAME, distance, getMaxRunDistance());
    }

    public void swim(int distance){
        movingAction(SWIM_ACTION_NAME, distance, getMaxSwimDistance());
    }

    public void movingAction(String actionName, int distance, int maxDistance) {
        if (distance > maxDistance){
            System.out.printf("%s %s %s только %dм. из %d%n", getAnimalTypeString(), getName(), actionName,  maxDistance, distance);
        } else {
            System.out.printf("%s %s %s %dм.%n",  getAnimalTypeString(), getName(), actionName,  distance);
        }
    }

}
