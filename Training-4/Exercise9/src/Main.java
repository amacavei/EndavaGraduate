import java.util.List;

/**
 * Created by amacavei on 7/22/2015.
 *
 * Define the Calculator class, which contains 3 methods:
 add(a: Integer, b: Integer): Integer
 divide(a: Integer, b: Integer): Integer
 average(collection: List<Integer>): Integer which uses add and devide
 Define the following exceptions:
 OverflowException: thrown whenever the sum of the two Integers exceeds Integer.MAX_VALUE
 UnderflowException: thrown whenever the sum of the two Integers is lower than Integer.MIN_VALUE
 Which kind of exceptions would you choose: checked or unchecked? Why?

 */
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();


        calc.addInt(Integer.MIN_VALUE,Integer.MIN_VALUE);
        calc.addInt(Integer.MAX_VALUE,Integer.MAX_VALUE);

        calc.divideInt(Integer.MAX_VALUE,Integer.MIN_VALUE);

    }
}
