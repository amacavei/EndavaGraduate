/**
 * Created by amacavei on 7/18/2015.
 */
public class Subscription extends Product{


    public Subscription(String name,int price)
    {
        super(name, price);
    }

    public String getName()
    {
        return super.name;
    }

    public int getPrice() {
        return super.getPrice()*12;
    }

    public void PrintSubscription()
    {
        System.out.println(getName() + " " + getPrice());
    }
}
