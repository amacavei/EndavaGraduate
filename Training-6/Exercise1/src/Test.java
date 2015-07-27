/**
 * Created by amacavei on 7/24/2015.
 */
public class Test {

    public static void main(String[] args) {


        Person person1 = new Person("Andrei", 1991);
        Person person2 = new Person("Ion", 1990);
        Person person3 = new Person("Silviu", 1992);
        Person person4 = new Person("Marcel", 1993);

        MyHashMap myhashmap = new MyHashMap();

        myhashmap.putPerson("person1",person1);
        myhashmap.putPerson("person2",person2);
        myhashmap.putPerson("person3",person3);

        myhashmap.printPerson("person1");

        myhashmap.contrainsPerson("person1");
        myhashmap.removePerson("person1");
        myhashmap.contrainsPerson("person1");

        myhashmap.printSetIterator();
        myhashmap.printValuesIterator();
    }


}
