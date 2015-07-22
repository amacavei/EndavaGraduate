/**
 * Created by amacavei on 7/22/2015.
 *
 * Given an array of scores, return true if each score is equal or greater than the one before.
 * The array will be length 2 or more. 
 *
 */
public class Main {

    public static void main(String[] args) {


        Scores score = new Scores();
        System.out.println(score.scoresIncreasing(new int[]{1,3,4}));
        System.out.println(score.scoresIncreasing(new int[]{1,3,2}));
        System.out.println(score.scoresIncreasing(new int[]{1,1,4}));

    }
}
