/**
 * Created by amacavei on 7/22/2015.
 *
 * We have an array of heights, representing the altitude along a walking trail.
 * Given start/end indexes into the array, return the sum of the changes for a
 * walk beginning at the start index and ending at the end index. For example,
 * with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1 + 5 = 6.
 * The start end end index will both be valid indexes into the array with start <= end.

 */
public class Main {

    public static void main(String[] args) {
        Heights heightsarray = new Heights();
        System.out.println(heightsarray.sumHeights(new int[]{5,3,6,7,2},2,4));
        System.out.println(heightsarray.sumHeights(new int[]{5,3,6,7,2},0,1));
        System.out.println(heightsarray.sumHeights(new int[]{5,3,6,7,2},0,4));
    }
}
