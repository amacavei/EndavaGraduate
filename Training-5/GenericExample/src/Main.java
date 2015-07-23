import java.util.ArrayList;
import java.util.List;

/**
 * Created by amacavei on 7/23/2015.
 */
public class Main {

    public static void listPizza (List<? extends Pizza> pizzaList){
        for(Pizza item : pizzaList)
            System.out.println(item.getName());
    }

    public static void main(String[] args) {
        List<Pizza> pList = new ArrayList<Pizza>();
        pList.add(new HamPizza());
        pList.add(new CheesePizza());
        pList.add(new Pizza());

        Main.listPizza(pList);
    }
}
