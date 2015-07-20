/**
 * Created by amacavei on 7/20/2015.
 */

//At the end of the following piece of code, what objects are s1 and s2 referencing?

public class Exercise7 {
    public static void main(String args[]) {
        Exercise7 s1 = new Exercise7();
        Exercise7 s2 = new Exercise7();
        s1 = s2;
    }
}
