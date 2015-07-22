/**
 * Created by amacavei on 7/22/2015.
 */
public class Main {

    public static void main(String[] args) {

        IntNumbers comp = new IntNumbers();


        System.out.println(comp.posNeg(1,-1,false));
        System.out.println(comp.posNeg(-1,1,false));
        System.out.println(comp.posNeg(-4,-5,true));

    }
}
