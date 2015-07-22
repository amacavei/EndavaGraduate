/**
 * Created by amacavei on 7/22/2015.
 *
 * Given a non-empty string and an int N, return the string made starting
 * with char 0, and then every Nth char of the string. So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.
 *
 */
public class Main {

    public static void main(String[] args) {

        NonEmpty Nthchr = new NonEmpty();

        System.out.println(Nthchr.everyNth("andrei",2));
    }
}
