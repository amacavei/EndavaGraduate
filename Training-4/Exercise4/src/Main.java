/**
 * Created by amacavei on 7/22/2015.
 *
 * Given a string, take the last char and return a new string with the last
 * char added at the front and back, so "cat" yields "tcatt". The original string will be length 1 or more. 
 *
 */
public class Main {

    public static void main(String[] args) {

        String oldstr = "andrei";

        CharStr newstr = new CharStr(oldstr);

        System.out.println(newstr.backAround(oldstr));
    }
}
