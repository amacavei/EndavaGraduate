/**
 * Created by amacavei on 7/20/2015.
 */
public class Exercise3 {


        public static void main(String args[]) {
            Exercise3 s1 = new Exercise3();
            Exercise3 s2 = new Exercise3();
            s1 = s2;
            System.out.println(s1 == s2);
            System.out.println(s1.equals(s2));
        }


}
