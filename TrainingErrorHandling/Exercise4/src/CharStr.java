/**
 * Created by amacavei on 7/22/2015.
 */


public class CharStr {
    String s;

    public CharStr(String s) {
        this.s = s;
    }
    public String backAround(String s) {

       return (s.charAt(s.length()-1) + s + s.charAt(s.length()-1));


    }

}
