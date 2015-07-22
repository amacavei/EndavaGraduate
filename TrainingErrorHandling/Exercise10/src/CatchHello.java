/**
 * Created by amacavei on 7/22/2015.
 */

// Fara exceptie de runtime blocul finally e executat dupa try deoarece contorul este incrementat de 2 ori : in try si in finally
// Daca am avea exceptie contorul ar fi incrementat inca o data in catch
public class CatchHello {
    public static int finEx(int i){
        try {
            System.out.println("Try !");
            i++;
            if(i==1)
            throw new RuntimeException();
            return i;


        }catch(RuntimeException e){
            i++;
            System.out.println("Catch !");

        }finally{
            i++;
            System.out.println("Finally !");
        }
        return i;
    }
}
