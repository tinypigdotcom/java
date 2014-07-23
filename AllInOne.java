import java.io.*;

// concept: class
class Bicycle {

    // the Bicycle class has three fields
    public int cadence, gear, speed;

    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
        reportInfo();
    }

    public void reportInfo() {
        System.out.println("Bicycle: " + cadence + " speed: " + speed + " gear: " + gear);
    }

    // the Bicycle class has four methods
    public void setCadence ( int newValue  ) { cadence = newValue ; reportInfo(); }
    public void setGear    ( int newValue  ) { gear    = newValue ; reportInfo(); }
    public void applyBrake ( int decrement ) { speed  -= decrement; reportInfo(); }
    public void speedUp    ( int increment ) { speed  += increment; reportInfo(); }

    public void fileIo     ( ) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            System.out.println(line);
        }
        br.close();
        bw.close();
        reportInfo();
    }
    // Q: What is static? What do the other keywords do?
}

// concept: subclass
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
    public void setHeight(int newValue) { seatHeight = newValue; }
}


public class AllInOne {
    public static void main (String[] args) throws IOException {

        Bicycle frank = new Bicycle(5,7,10); // concept: object, class instance
        frank.setGear(3);                    // concept: call method

        int inputNumber = Integer.parseInt(args[0]); // concept: command line argument
        String outputString;

        switch (inputNumber) { // concept: switch
            case 1:  outputString = "One";
                     break;
            case 3:  outputString = "Three";
                     break;
            default: outputString = "Invalid";
                     break;
        }
        System.out.println(outputString); // concept: console output
        frank.fileIo();
    }
}

