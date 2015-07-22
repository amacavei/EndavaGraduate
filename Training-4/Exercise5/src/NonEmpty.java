/**
 * Created by amacavei on 7/22/2015.
 */
public class NonEmpty {

    String s;
    int N;

    public NonEmpty() {
        s = "0";
        N = 0;
    }

    public String everyNth(String s, int N){

        StringBuilder newstr = new StringBuilder();
        for(int i = 0;i < s.length();i+=N){
            newstr.append(s.charAt(i));
        }
        return newstr.toString();
    }
}
