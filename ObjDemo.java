class Bicycle {

    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;

    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
        System.out.println("j3 constructor");
        reportInfo();
    }

    public void reportInfo() {
        System.out.println("j2 cadence: " + cadence + " speed: " + speed + " gear: " + gear);
    }

    // the Bicycle class has four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        int wasgear = gear;
        gear = newValue;
        System.out.println("j1 setGear(" + newValue + ")");
        reportInfo();
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

}

// A class declaration for a MountainBike class that is a subclass of Bicycle might look like this:
class MountainBike extends Bicycle {

    // the MountainBike subclass has one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight, int startCadence,
                        int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // the MountainBike subclass has one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

}


public class ObjDemo {
    public static void main(String[] args) {
        Bicycle frank = new Bicycle(5,7,10);
        frank.setGear(12);
    }
}

