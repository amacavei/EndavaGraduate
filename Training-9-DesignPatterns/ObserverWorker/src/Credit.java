/**
 * Created by amacavei on 7/29/2015.
 */
public class Credit extends Observer {


    public Credit(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        if(subject.getBrutSalary() > 5000)
            System.out.println("Credit");
    }
}
