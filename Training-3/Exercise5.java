/**
 * Created by amacavei on 7/20/2015.
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise5 {

    public static void main(String[] args) {


        Character ch = 'a'; //Autoboxing

        Integer i = new Integer(-8);


        // 1. Unboxing through method invocation
        int absval = absoluteValue(i);
        System.out.println("absolute value of " + i + " = " + absval);

        List<Double> ld = new ArrayList<>();
        ld.add(3.1416);

        // 2. Unboxing through assignment
        double pi = ld.get(0);
        System.out.println("pi = " + pi);
    }

    public static int absoluteValue(int i) {

        return (i < 0) ? -i : i;
    }
}


