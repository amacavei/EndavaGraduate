/**
 * Created by amacavei on 7/22/2015.
 *
 * Given two int values, return true if one is negative and one is positive.
 * Except if the parameter "negative" is true, then return true only if both are negative. 
 *
 */
public class Main {

    public static void main(String[] args) {

        IntNumbers comp = new IntNumbers();


        System.out.println(comp.posNeg(1,-1,false));
        System.out.println(comp.posNeg(-1,1,false));
        System.out.println(comp.posNeg(-4,-5,true));

    }
}
