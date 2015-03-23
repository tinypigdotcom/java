import java.util.*;
public class MyFoo {
    public static void main (String[] args) {
        ArrayList<Integer> listA = new ArrayList<Integer>();
        Integer b = 8;

        listA.add(b);
        listA.add(7);
        listA.add(9);

        listA.add(1, 11);
        Collections.sort(listA,Collections.reverseOrder());
        for (Iterator<Integer> it = listA.iterator(); it.hasNext();) {
            System.out.println("Item is: " + it.next());
        }
    }
}

