/*
sub roll {
    my ($dice) = @_;
    if ( $dice =~ /^\d+$/ ) {
        return $dice;
    }
    my ($multiplier, $die, $bonus);
    if ( $dice =~ /^(\d*)d(\d+)(.*)/ ) {
        ($multiplier, $die, $bonus) = ($1,$2,$3);
    }
    else {
        croak "Invalid format";
    }
    $multiplier ||= 1;
    my $total = 0;
    for ( 1 .. $multiplier ) {
        $total += random($die);
    }
    eval "\$total = $total $bonus";
    return $total;
}
*/

/*
Pattern datePatt = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
...
Matcher m = datePatt.matcher(dateStr);
if (m.matches()) {
  int day   = Integer.parseInt(m.group(1));
  int month = Integer.parseInt(m.group(2));
  int year  = Integer.parseInt(m.group(3));
}
*/

import java.util.regex.*;
import java.util.Random;
import rpg.*;

public class CharacterGenerate {
    public static void main (String[] args) {
        if (args.length == 0) {
            System.out.println("No args!");
        }
        else {
            DiceRoller oDiceRoller = new DiceRoller();
            oDiceRoller.rollDice(args[0]);
        }
    }
}

