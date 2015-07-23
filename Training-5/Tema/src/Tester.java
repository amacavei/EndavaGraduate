import java.util.ArrayList;
import java.util.List;

/**
 * Created by amacavei on 7/23/2015.
 *
 * 2)	Update the Tester class to use a Generic List instead of a List of Strings.
 * You will create a generic type declaration by introducing the type variable, T,
 * that can be used anywhere inside the class. In the main method instantiate a Tester class
 * that uses a List of Integers and another one that uses a List of Floats
 * 
 */
public class Tester <T>{

    /* The list of bugs */
    private List<T> bugs;

    /* Constuctor where you initialize the list of bugs */
    public Tester() {
        bugs = new ArrayList<>();
    }

    /* Method for adding a bug to the bug list */
    public void  addBug(T newbug){
        bugs.add(newbug);
    }

    /* Method for getting the last bug from the bug list */
    public T getLastBug(){

        return bugs.get(bugs.size()-1);
    }

    /* Main method for testing the class functionality */
    public static void main(String[] args) {
        Tester<Integer> integertestbugs = new Tester<Integer>();
        Tester<String> stringtestbugs = new Tester<String>();

        integertestbugs.addBug(1);
        integertestbugs.addBug(2);
        integertestbugs.addBug(3);
        stringtestbugs.addBug("First bug");
        stringtestbugs.addBug("Second bug");
        stringtestbugs.addBug("Last bug");

        System.out.printf("Last String: %s\n", stringtestbugs.getLastBug());
        System.out.printf("Last Integer: %d\n",integertestbugs.getLastBug());
    }
}
