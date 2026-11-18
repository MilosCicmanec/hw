import Animals.Flyable;
import Animals.Swimmable;

public class duck implements Flyable, Swimmable {
    private int altitude;
    @Override
    public void fly() {
        System.out.println("Flying!");
    }
    public duck(int altitude) {
        this.altitude = altitude;
    }
    @Override
    public void descend(int meters) {
        if (altitude - meters >= 0) {
            System.out.println("Descended by" + meters);
            altitude -= meters;
        }else {
            System.out.println("Not enough meters");
        }
    }

    @Override
    public void ascend(int meters) {
        System.out.println("Ascended by" + meters);
        altitude += meters;
    }

    @Override
    public void land() {
        if (altitude == 0) {
            System.out.println("landing!");
        } else {
            System.out.println("not on the ground");
        }
    }

    @Override
    public void swim() {
        if (altitude == 0) {
            System.out.println("swiming!");
        } else {
            System.out.println("not on the ground");
        }
    }
}
