/**
 * Created by amacavei on 7/22/2015.
 */
public class IntNumbers {

    int a;
    int b;
    boolean negative;

    public IntNumbers() {
        a=0;
        b=0;
        negative = false;
    }

    public boolean posNeg(int a, int b, boolean negative){
        return ((negative || ((a>0 && b<0) || (a<0 && b>0))) || (negative && (a<0 && b<0)));
    }
}
