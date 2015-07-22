/**
 * Created by amacavei on 7/22/2015.
 */
public class Main {

    public static void main(String[] args) {

        String oldstr = "andrei";

        CharStr newstr = new CharStr(oldstr);

        System.out.println(newstr.backAround(oldstr));
    }
}
