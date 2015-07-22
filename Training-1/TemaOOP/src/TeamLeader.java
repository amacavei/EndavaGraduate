/**
 * Created by amacavei on 7/18/2015.
 */
public class TeamLeader extends SalesAgent
{
    public int leadercomission;

    TeamLeader(String firstname,String lastname,int agentcomission,int leadercomission,String name,int price)
    {
        super(firstname, lastname,agentcomission,name,price);
        this.leadercomission = leadercomission;
    }

    public int getLeaderComission()
    {
        return leadercomission;
    }

    public float getAgentSalesValue()
    {
        return super.getPrice()*((leadercomission/getAgentComission())/100f);
    }

    public float getLeaderSalesValue()
    {
        return price*getLeaderComission()/100f;
    }

    public float getTotalLeaderValue()
    {
        return getAgentSalesValue()+getLeaderSalesValue();
    }


    public void PrintLeader()
    {
        System.out.println(firstname + " " + lastname + "\n" + "Comission = " + getLeaderComission() + " " + "Leader Value" + " " + getTotalLeaderValue());
    }

}
