import java.util.ArrayList;

/**
 * Created by amacavei on 7/28/2015.
 */
public class RandomNumbers extends Thread{

    ArrayList<Integer> primenb = new ArrayList<>();
    ArrayList<Integer> randomnb = new ArrayList<>();
    public int p;
    int prime;
    public int startIndex;
    public int endIndex;

    public RandomNumbers(ArrayList<Integer> primenb,ArrayList<Integer> randomnb,int startIndex,int endIndex) {
        this.primenb = primenb;
        this.randomnb = randomnb;
        this.startIndex = startIndex;
        this.endIndex = endIndex;

    }


    public void isPrime(int n){
        p = 2;
        prime = 0;
        while (p <= (n / 2)) {
            if (n % p == 0) {
                prime = 1;
            }
            p++;
        }

        if (prime != 1) {
            synchronized (this.primenb)   {primenb.add(n);}
        }
    }


    @Override
    public void run() {

        for (int i = startIndex ;i < endIndex; i++) {
            isPrime(randomnb.get(i));
        }


    }


}
