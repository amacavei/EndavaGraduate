/**
 * Created by amacavei on 7/22/2015.
 *
 * We have two monkeys, a and b, and the parameters aSmile and bSmile
 * indicate if each is smiling. We are in trouble if they are both smiling
 * or if neither of them is smiling. Return true if we are in trouble.

 */
public class Main {

    public static void main(String[] args) {

        Monkey smile = new Monkey();

        System.out.println(smile.monkeyTrouble(true,true));
        System.out.println(smile.monkeyTrouble(false,false));
        System.out.println(smile.monkeyTrouble(true,false));
    }
}
