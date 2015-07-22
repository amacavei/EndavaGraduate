/**
 * Created by amacavei on 7/18/2015.
 */
public class Product {
    public String name;
    public int price;


    public Product(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public int getPrice()
    {
        return price;
    }

    public void PrintProduct()
    {
        System.out.println(name + " " + price);
    }
}
