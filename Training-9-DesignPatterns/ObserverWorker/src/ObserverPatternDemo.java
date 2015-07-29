/**
 * Created by amacavei on 7/29/2015.
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();
        int brutsalary = 20;
        new BrutSalaryObserver(subject);
        new NetSalaryObserver(subject);
        new EmailSender(subject);
        new Credit(subject);

        subject.setBrutSalary(brutsalary);
        System.out.println("First salary : " + (subject.getBrutSalary()));
        subject.setBrutSalary(brutsalary +5000);
        System.out.println("Second salary raise : " + (subject.getBrutSalary()));





    }
}
