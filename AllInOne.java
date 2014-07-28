import java.io.*;
import java.util.*;
import java.util.regex.Pattern; // concept: import a single symbol from a package

public class AllInOne {
    // Q: What is static? What do the other keywords do?
    public static void main (String[] args) throws IOException {
        String[] vanilla = { "ice", "ice", "baby" };
        System.out.println("--------------- START ---------------");

        OutputMgr oMan = new OutputMgr();

        MyUtil utilObject = new MyUtil();
        oMan.omPrint( utilObject.fileIo() );
        oMan.omPrint( utilObject.doHash() );

        int i = 1;
        if ( args.length > 0 ) {
            i = Integer.parseInt(args[0]); // concept: command line argument
        }
        oMan.omPrint( utilObject.doSwitch(i) );
        oMan.omPrint( utilObject.printArgs(args) );
        oMan.omPrintLines( vanilla );

        BasketBall mrBall = new BasketBall ( 7, "square", 3 ); // concept: object, class instance
        mrBall.setOrangeness(2);   // concept: call method
        oMan.omPrint(  mrBall.getOutput() );

        System.out.println("---------------  END  ---------------"); System.exit(0); // concept: exit
        System.out.println("|-|-|-|-|-|-|-|  DIE  |-|-|-|-|-|-|-|"); System.exit(1); // concept: die
    }
}

// concept: class
class MyUtil {
    public MyUtil( ) { }

    public String fileIo     ( ) throws IOException {
        String returnString = "";
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            returnString += line + "\n";
        }
        br.close();
        bw.close();
        return returnString;
    }

    public String printArgs ( String[] inArgs ) {
        String returnString = "";
        for (String s: inArgs) { // concept: for loop, array loop
            returnString += s;
        }
        return returnString;
    }

    public String doSwitch ( int inputNumber ) {
        String returnString = "";

        switch (inputNumber) { // concept: switch
            case 1:  returnString = "Foo";
                     break;
            case 7:  returnString = "Bar";
                     break;
            default: returnString = "Invalid";
                     break;
        }
        return returnString;
    }
    public String doHash ( ) {
        String returnString = "";
        // Create a hash map
        HashMap<String, Double> hm = new HashMap<>();
        // Put elements to the map
        hm.put("Zara",   new Double( 3434.34 ));
        hm.put("Qadir",  new Double(  -19.08 ));

        // Get a set of the entries
        Set set = hm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            returnString += me.getKey() + ": " + me.getValue() + "\n";
        }
        // Deposit 1000 into Zara's account
        double balance = ((Double)hm.get("Zara")).doubleValue();
        hm.put("Zara", new Double(balance + 1000));
        returnString += "Zara's new balance: " + hm.get("Zara") + "\n";
        return returnString;
    }
}

class Spacer {
    public String spaces = "";
    public Spacer ( ) { }
    public void bumpSpace  ( ) { spaces += "    "; }
    public String getSpace ( ) { return spaces;    }
}

class OutputMgr {
    public Spacer omSpacer;
    public OutputMgr ( ) {
        omSpacer = new Spacer();
    }
    public void omPrint  ( String omLines ) {
        omLines = omLines.replaceAll("(?m)^", omSpacer.getSpace());
        System.out.println( omLines ); // concept: console output
        omSpacer.bumpSpace();
    }
    public void omPrintLines ( String[] lines ) {
        String returnString = "";
        for (String s: lines) {
            System.out.println( s );
        }
    }

}

class BallDaddy {
    public int size;
    public String outputString;
    public String shape;
    public BallDaddy ( int startSize, String startShape ) {
        size = startSize;
        shape = startShape;
        outputString = "";
        reportInfo();
    }
    public void reportInfo() {
        outputString += "Ball:"
                     + " size: " + size
                     + " shape: "   + shape;
    }
    public String getOutput() {
        return outputString;
    }
    public void clearOutput() {
        outputString = "";
    }
    public void setSize  ( int newValue     ) { size  = newValue; reportInfo(); }
    public void setShape ( String newValue  ) { shape = newValue; reportInfo(); }
}

class Ball extends BallDaddy { // subclasses have to add newline I guess?
    public Ball ( int startSize, String startShape ) {
        super(startSize, startShape);
    }
    public void reportInfo() { super.reportInfo(); outputString += "\n"; }
}

// concept: subclass
class BasketBall extends BallDaddy {
    public int orangeness;
    public BasketBall ( int startSize, String startShape,
                        int startOrangeness ) {
        super(startSize, startShape);
        orangeness = startOrangeness;
    }
    public void reportInfo() {
        super.reportInfo();
        outputString += " orangeness: "   + orangeness + "\n";
    }
    public void setOrangeness( int newValue  ) { orangeness = newValue; reportInfo(); }
}

