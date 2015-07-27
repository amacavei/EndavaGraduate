import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by amacavei on 7/24/2015.
 */
public class MyHashMap{

    final HashMap<String,Person> hashmap = new HashMap(1,1);


public void putPerson(String name,Person person){
    hashmap.put(name, person);

}

    public void printSetIterator(){
        final Set set = hashmap.entrySet();
        final Iterator i = set.iterator();

        while(i.hasNext()) {
            final Map.Entry me = (Map.Entry) i.next();
            System.out.println("Set Iterator :" + " " + me.getKey() + " " + me.getValue());
        }
    }

    public void printValuesIterator(){

        final Iterator it = hashmap.values().iterator();

        while(it.hasNext()) {

            System.out.println("Values Iterator :" + " " + it.next());
        }
    }

    public void removePerson(String name){
        hashmap.remove(name);
    }

    public void printPerson(String name){
        System.out.println(hashmap.get(name).toString());
    }

    public void contrainsPerson(String name){
        System.out.println(hashmap.containsKey(name));
    }

}
