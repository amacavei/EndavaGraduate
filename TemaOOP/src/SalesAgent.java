/**
 * Created by amacavei on 7/18/2015.
 */
public class SalesAgent extends Product{
    public String firstname;
    public String lastname;
    public int comission;




    SalesAgent(String firstname, String lastname, int comission, String name, int price)
    {
        super(name, price);
        this.firstname = firstname;
        this.lastname = lastname;
        this.comission = comission;

    }

    public int getAgentComission()
    {
        return comission;
    }



    public float getAgentValue()
    {

        return super.getPrice()*(comission/100f);
    }

    public void PrintAgent()
    {
        System.out.println(firstname + " " + lastname + "\n" + "Price = " + " " + getPrice() + " " + "Comission = " + comission  + " " + "Value" + " " + getAgentValue());
    }
}
