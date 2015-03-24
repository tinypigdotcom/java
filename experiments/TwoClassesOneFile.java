
public class TwoClassesOneFile {
    public static void main (String[] args) {
        System.out.println("Can you have two classes in one file?");
        MyUtil utilObject = new MyUtil();
        utilObject.answerYes();
    }
}

// concept: class
class MyUtil {
    public MyUtil( ) { }
    public static void answerYes () {
        System.out.println("Yes you can\n");
    }
}


