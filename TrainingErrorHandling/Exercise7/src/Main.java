/**
 * Created by amacavei on 7/22/2015.
 */
public class Main {

    public static void main(String[] args) {
        Heights heightsarray = new Heights();
        System.out.println(heightsarray.sumHeights(new int[]{5,3,6,7,2},2,4));
        System.out.println(heightsarray.sumHeights(new int[]{5,3,6,7,2},0,1));
        System.out.println(heightsarray.sumHeights(new int[]{5,3,6,7,2},0,4));
    }
}
