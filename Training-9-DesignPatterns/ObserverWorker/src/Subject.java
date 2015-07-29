import java.util.ArrayList;
import java.util.List;

/**
 * Created by amacavei on 7/29/2015.
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int brutsalary;

    public int getBrutSalary(){
        return brutsalary;
    }

    public void setBrutSalary(int brutsalary){
        this.brutsalary = brutsalary;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
