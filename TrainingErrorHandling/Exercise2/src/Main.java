/**
 * Created by amacavei on 7/22/2015.
 *
 * We have a loud talking parrot. The "hour" parameter is the current
 * hour time in the range 0..23. We are in trouble if the parrot is talking
 * and the hour is before 7 or after 20. Return true if we are in trouble. 
 *
 */
public class Main {
    public static void main(String[] args) {
        Parrot parrot1 = new Parrot();


        System.out.println(parrot1.parrotTrouble(true,6));
        System.out.println(parrot1.parrotTrouble(true,7));
        System.out.println(parrot1.parrotTrouble(false,7));

    }
}
