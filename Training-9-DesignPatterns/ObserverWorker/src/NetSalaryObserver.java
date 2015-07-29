/**
 * Created by amacavei on 7/29/2015.
 */
public class NetSalaryObserver extends Observer{

        public NetSalaryObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("Net Salary " + (subject.getBrutSalary()-5));
        }
    }

