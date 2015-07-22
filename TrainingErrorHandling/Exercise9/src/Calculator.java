import java.util.List;

/**
 * Created by amacavei on 7/22/2015.
 */
public class Calculator {
    public void addInt(int a, int b) throws OverflowException, UnderflowException {
        long sum = (long) a + (long) b;
        if (sum > Integer.MAX_VALUE)
            throw new OverflowException();
        if (sum < Integer.MIN_VALUE)
            throw new UnderflowException();
    }

    public float divideInt(int a, int b) {
        return (float) (a / b);
    }

    public double average(List<Integer> intList) {
        int sum = 0;

        for (int i : intList) {
            addInt(sum, i);
        }
        return sum / intList.size();
    }
}
