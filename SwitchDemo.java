class Bicycle {

    // the Bicycle class has
    // three fields
    public int cadence;
    public int gear;
    public int speed;

    // the Bicycle class has
    // one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    // the Bicycle class has
    // four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        gear = newValue;
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

    // the MountainBike subclass has
    // one field
    public int seatHeight;

    // the MountainBike subclass has
    // one constructor
    public MountainBike(int startHeight, int startCadence,
                        int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // the MountainBike subclass has
    // one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

}


public class SwitchDemo {
    public static void main(String[] args) {

        int nummy = 3;
        // nummy = Integer.parseInt(args[0]);
        String nummyString;
        Bicycle frank = new Bicycle(5,7,10);
        switch (nummy) {
            case 1:  nummyString = "One";
                     break;
            case 2:  nummyString = "Two";
                     break;
            case 3:  nummyString = "Three";
                     break;
            default: nummyString = "Invalid nummy";
                     break;
        }
        System.out.println(nummyString);
    }
}

