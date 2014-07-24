import java.io.*;
import java.util.*;

// concept: class
class MyUtil {

    public MyUtil( ) {
    }

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
    }
    public void doSwitch ( int inputNumber ) {
        String outputString;
        String spaces = "        ";

        switch (inputNumber) { // concept: switch
            case 1:  outputString = spaces + "Foo";
                     break;
            case 3:  outputString = spaces + "Bar";
                     break;
            default: outputString = spaces + "Invalid";
                     break;
        }
        System.out.println(outputString); // concept: console output

    }
    // Q: What is static? What do the other keywords do?
    public void doHash ( ) {
        String spaces = "    ";
        // Create a hash map
        HashMap<String, Double> hm = new HashMap<>();
        // Put elements to the map
        hm.put("Zara",   new Double( 3434.34 ));
        hm.put("Mahnaz", new Double(  123.22 ));
        hm.put("Qadir",  new Double(  -19.08 ));

        // Get a set of the entries
        Set set = hm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(spaces + me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
        // Deposit 1000 into Zara's account
        double balance = ((Double)hm.get("Zara")).doubleValue();
        hm.put("Zara", new Double(balance + 1000));
        System.out.println(spaces + "Zara's new balance: " +
        hm.get("Zara"));

    }
}

class Spacer {
    public String spaces;
    public Spacer ( ) { }
    public void bumpSpace  ( ) { spaces += "    "; }
    public String getSpace ( ) { return spaces;    }
}

class Ball {
    public int size;
    public String shape;
    public Ball ( int startSize, String startShape ) {
        size = startSize;
        shape = startShape;
        reportInfo();
    }
    public void reportInfo() {
        String spaces = "            ";
        System.out.println(
            spaces + "Ball:"
            + " size: " + size
            + " shape: "   + shape
        );
    }
    public void setSize  ( int newValue     ) { size  = newValue ; reportInfo(); }
    public void setShape ( String newValue  ) { shape = newValue ; reportInfo(); }
}

// concept: subclass
class BasketBall extends Ball {
    public int orangeness;
    public BasketBall ( int startSize, String startShape,
                        int startOrangeness ) {
        super(startSize, startShape);
        orangeness = startOrangeness;
    }
    public void setOrangeness( int newValue ) {
        orangeness = newValue;
    }
}

public class AllInOne {
    public static void main (String[] args) throws IOException {
        System.out.println("--------------- START ---------------");

        Spacer mySpacer = new Spacer();

        MyUtil utilObject = new MyUtil();
        utilObject.fileIo();
        utilObject.doHash();

        int i = 1;
        if ( args.length > 0 ) {
            i = Integer.parseInt(args[0]); // concept: command line argument
        }
        utilObject.doSwitch(i);

        for (String s: args) { // concept: for loop, array loop
            System.out.println(s);
        }

        Ball mrBall = new Ball ( 7, "green" ); // concept: object, class instance
        mrBall.setSize(2);                     // concept: call method

        System.out.println("---------------  END  ---------------"); System.exit(0); // concept: exit
        System.out.println("|-|-|-|-|-|-|-|  DIE  |-|-|-|-|-|-|-|"); System.exit(1); // concept: die
    }
}

