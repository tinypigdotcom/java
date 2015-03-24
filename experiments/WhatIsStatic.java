
// The static keyword denotes that a member variable, or method, can be
// accessed without requiring an instantiation of the class to which it
// belongs. In simple terms, it means that you can call a method, even if
// you've never created the object to which it belongs!

public class WhatIsStatic {
    public static void main (String[] args) {
        System.out.println("Can you call a static method without instatiating an object?");
        MyUtil.answerYes();
    }
}

class MyUtil {
    public static void answerYes () {
        System.out.println("You sure can!");
    }
}

