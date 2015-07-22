import java.util.List;

/**
 * Created by amacavei on 7/22/2015.
 */
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();


        calc.addInt(Integer.MIN_VALUE,Integer.MIN_VALUE);
        calc.addInt(Integer.MAX_VALUE,Integer.MAX_VALUE);

        calc.divideInt(Integer.MAX_VALUE,Integer.MIN_VALUE);

    }
}
