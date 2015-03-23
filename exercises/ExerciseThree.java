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

public class ExerciseThree {
    public static void main (String[] args) {
        if (args.length == 0) {
            System.out.println("No args!");
        }
        else {
            Pattern rollPatt = Pattern.compile("^(\\d*)d(\\d+)(.*)");
            Matcher m = rollPatt.matcher(args[0]);
            if (m.matches()) {
                int multiplier=0;
                int die=0;
                int total=0;
                String bonus="";
                if (m.matches()) {
                    multiplier = Integer.parseInt(m.group(1));
                    die        = Integer.parseInt(m.group(2));
                    bonus      = m.group(3);
                }
                System.out.println("multiplier: " + multiplier + "  die: " + die + "  bonus: " + bonus);
                Random randomGenerator = new Random();
                for (int idx = 1; idx <= multiplier; ++idx){
                    int randomInt = randomGenerator.nextInt(die)+1;
                    System.out.println("Generated: " + randomInt);
                    total += randomInt;
                }
                System.out.println("total: " + total);
            }
            System.out.println("args, like " + args[0]);
        }
    }
}

