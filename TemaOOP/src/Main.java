/**
 * Created by amacavei on 7/18/2015.
 */
public class Main {

    public static void main(String[] args) {


        Product TV = new Product("TV", 1250);
        Product Internet = new Product("Internet", 1400);
        TV.PrintProduct();
        Internet.PrintProduct();
        Subscription TVSub = new Subscription(TV.name,TV.price);
        TVSub.PrintSubscription();


        SalesAgent agent1 = new SalesAgent("Andrei","Macavei",3,TV.name,TV.price);
        SalesAgent leader1 = new SalesAgent("Ion","Popescu",7,Internet.name,Internet.price);

        SalesAgent ag1 = new SalesAgent(agent1.firstname,agent1.lastname,agent1.comission,agent1.name,agent1.price);
        ag1.PrintAgent();

        TeamLeader l1 = new TeamLeader(leader1.firstname,leader1.lastname,agent1.comission,leader1.comission,leader1.name,leader1.price);
        l1.PrintLeader();
    }
}
