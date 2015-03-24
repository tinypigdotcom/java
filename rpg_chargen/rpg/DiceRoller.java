
package rpg;
import java.util.*;
import java.util.regex.*;
import java.util.Random;

public class DiceRoller {
    private boolean debug = false;
    public void setDebug (boolean newValue) {
        debug = newValue;
    }
    public boolean getDebug () {
        return debug;
    }
    public void doPrintLine ( String output ) {
        System.out.println(output);
    }
    public void doPrint ( String output ) {
        System.out.print(output);
    }
    public void debugOut ( String output ) {
        if ( debug ) {
            System.out.println(output);
        }
    }
    public ArrayList<Integer> rollDice ( String rollstring ) {
        String pattStart = "^\\s*(\\d*)\\s*d\\s*(\\d+)\\s*(?:(";
        String pattEnd   = ")\\s*(\\d+))?\\s*$";
        Pattern bestPatt = Pattern.compile(pattStart + "best" + pattEnd);
        Pattern rollPatt = Pattern.compile(pattStart + "[+-]" + pattEnd);
        Matcher b = bestPatt.matcher(rollstring);
        Matcher m = rollPatt.matcher(rollstring);
        Matcher j = b;
        ArrayList<Integer> diceList = new ArrayList<Integer>();
        if (m.matches()) {
            j=m;
        }
        if (j.matches()) {
            int multiplier=0;
            int die=0;
            int total=0;
            int bonus=0;
            String bonusstring="";
            String modifystring="";
            String multiplierstring = j.group(1);
            if ( multiplierstring.equals("") ) {
                multiplierstring = "1";
            }
            multiplier = Integer.parseInt(multiplierstring);
            die        = Integer.parseInt(j.group(2));
            modifystring = j.group(3);
            bonusstring = j.group(4);
            if ( bonusstring == null ) {
                bonus = 0;
            }
            else if ( bonusstring.equals("") ) {
                bonus = 0;
            }
            else {
                bonus = Integer.parseInt(bonusstring);
            }
            debugOut("multiplier: " + multiplier + "  die: " + die + "  bonus: " + bonus);
            Random randomGenerator = new Random();
            for (int idx = 1; idx <= multiplier; ++idx){
                int randomInt = randomGenerator.nextInt(die)+1;
                doPrint(" " + randomInt);
                diceList.add(randomInt);
            }
            Collections.sort(diceList,Collections.reverseOrder());
            boolean best = false;
            if (modifystring != null) {
                best = modifystring.equals("best");
            }
            if ( best ) {
                if ( bonus > diceList.size() ) {
                    bonus = diceList.size();
                }
                diceList.subList(bonus, diceList.size()).clear();
            }
            Integer item=0;
            for (Iterator<Integer> it = diceList.iterator(); it.hasNext();) {
                item = it.next();
                total += item;
                debugOut("Item is: " + item);
            }
            debugOut(": " + total);
            if ( modifystring == null ) {
            }
            else if ( modifystring.equals("-") ) {
                total -= bonus;
            }
            else if ( modifystring.equals("+") ) {
                total += bonus;
            }
            doPrintLine(": " + total);
        }
        else {
            doPrintLine("bad dice");
        }
        return diceList;
    }

}


