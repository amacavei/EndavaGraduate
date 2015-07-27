/**
 * Created by amacavei on 7/24/2015.
 */
public class TVSeries {

    public String name;
    public String hour;
    public String day;
    public String productionyear;
    public String productiontype;

    public TVSeries(String name, String hour, String day, String productionyear, String productiontype) {
        this.name = name;
        this.hour = hour;
        this.day = day;
        this.productionyear = productionyear;
        this.productiontype = productiontype;
    }

    public String getName() {
        return name;
    }

    public String getHour() {
        return hour;
    }

    public String getDay() {
        return day;
    }

    public String getProductionyear() {
        return productionyear;
    }

    public String getProductiontype() {
        return productiontype;
    }

    public String toString(){
        return getName() + getHour() + getDay() + getProductionyear() + getProductiontype();

    }
}
