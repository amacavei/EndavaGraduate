/**
 * Created by amacavei on 7/22/2015.
 *
 * Write a method which throws OutOfMemoryError and one which throws StackOverflowError.
 * Can you continue running the program after intercepting the error?
 *

 */
public class Main {
    public static void main(String[] args) {
        Exception8 e8= new Exception8();

        e8.outofMemory();
        //e8.stackOverflow();

    }
}
