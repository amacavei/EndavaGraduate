/**
 * Created by amacavei on 7/22/2015.
 */
public class Parrot {

    boolean talk;
    int hour;

    public Parrot() {
        talk = false;
        hour = 0;
    }

    public boolean parrotTrouble(boolean talk, int hour){
        return (talk &&  (hour < 7 || hour > 20));
    }
}
