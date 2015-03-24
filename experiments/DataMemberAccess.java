
public class DataMemberAccess {
    public static void main (String[] args) {
        System.out.println("Can you modify another class' public variable directly?");
        MyUtil utilObject = new MyUtil();
        utilObject.trueOrFalse = true;
        utilObject.answerYes();
    }
}

class MyUtil {
    public boolean trueOrFalse = false;
    public void answerYes () {
        if (trueOrFalse) {
            System.out.println("You sure can!");
        }
    }
}

