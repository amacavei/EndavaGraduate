/**
 * Created by amacavei on 7/29/2015.
 */
public class EmailSender extends Observer {

    int prevsalary;

    public EmailSender(Subject subject){
        prevsalary = subject.getBrutSalary();
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        if(subject.getBrutSalary() > prevsalary)
        System.out.println("Email");
        prevsalary = subject.getBrutSalary();
    }
}

