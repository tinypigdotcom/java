
package rpg;
import java.util.*;
import java.util.regex.*;
import java.util.Random;

public class DiceRoller {
    public void rollDice ( String rollstring ) {
        Pattern bestPatt = Pattern.compile("^\\s*(\\d*)\\s*d\\s*(\\d+)\\s*(?:(best)\\s*(\\d+))?\\s*$");
        Pattern rollPatt = Pattern.compile("^\\s*(\\d*)\\s*d\\s*(\\d+)\\s*(?:([+-])\\s*(\\d+))?\\s*$");
        Matcher b = bestPatt.matcher(rollstring);
        Matcher m = rollPatt.matcher(rollstring);
        Matcher j = b;
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
            if (j.matches()) {
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
            }
            System.out.println("multiplier: " + multiplier + "  die: " + die + "  bonus: " + bonus);
            Random randomGenerator = new Random();
            ArrayList<Integer> diceList = new ArrayList<Integer>();
            for (int idx = 1; idx <= multiplier; ++idx){
                int randomInt = randomGenerator.nextInt(die)+1;
                System.out.println("Generated: " + randomInt);
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
                System.out.println("Item is: " + item);
            }
            System.out.println("total: " + total);
            if ( modifystring == null ) {
            }
            else if ( modifystring.equals("-") ) {
                total -= bonus;
            }
            else if ( modifystring.equals("+") ) {
                total += bonus;
            }
            System.out.println("total: " + total);
        }
        else {
            System.out.println("bad dice");
        }
    }

}


