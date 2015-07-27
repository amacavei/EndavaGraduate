/**
 * Created by amacavei on 7/24/2015.
 */
public class Person {

    public String name;
    public final int birthyear;

    public Person(String name,int birthyear) {
        this.birthyear = birthyear;
        this.name = name;
    }

    @Override
    public String toString() {
        return getName() + " " + getBirthyear();
    }

    public String getName() {
        return name;
    }

    public int getBirthyear() {
        return birthyear;
    }
}
