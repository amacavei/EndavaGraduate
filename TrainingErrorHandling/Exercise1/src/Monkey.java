/**
 * Created by amacavei on 7/22/2015.
 */
public class Monkey {

    boolean aSmile;
    boolean bSmile;

    public Monkey() {
        aSmile = false;
        bSmile = false;
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile)
    {
        return (aSmile == bSmile);
    }
}

