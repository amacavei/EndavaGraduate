/**
 * Created by amacavei on 7/22/2015.
 *
 * . Demonstrate the execution of a finally block, even though a return is called from the main method.
 *
 */
public class Main {
    public static void main(String[] args){
        CatchHello hello = new CatchHello();
        System.out.println(hello.finEx(0));
    }
}
