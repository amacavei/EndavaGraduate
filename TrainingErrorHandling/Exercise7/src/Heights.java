/**
 * Created by amacavei on 7/22/2015.
 */
public class Heights {
    int sum;

    public int sumHeights(int[] heights, int start, int end) {
        sum=0;
        for (int i = start + 1; i <= end; i++)

            sum = Math.abs((heights[i]) - heights[i - 1]) + sum;

        return sum;
    }
}
