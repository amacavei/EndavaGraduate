/**
 * Created by amacavei on 7/29/2015.
 */
public class BrutSalaryObserver extends Observer{

        public BrutSalaryObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("Brut Salary: " + subject.getBrutSalary());
        }
    }

