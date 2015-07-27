import java.util.Comparator;

/**
 * Created by amacavei on 7/27/2015.
 */
public class Compare implements Comparator<String> {


        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

