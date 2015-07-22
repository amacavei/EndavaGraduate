/**
 * Created by amacavei on 7/22/2015.
 */
public class Scores {

    public boolean scoresIncreasing(int[] scoresarray){
        for(int i = 0;i < scoresarray.length-1; i++){
            if(scoresarray[i+1] < scoresarray[i])
                return false;
        }
        return true;

    }

}
