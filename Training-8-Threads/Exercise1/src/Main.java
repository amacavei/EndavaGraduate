import java.util.ArrayList;
import java.util.Random;

/**
 * Created by amacavei on 7/28/2015.
 */
public class Main extends Thread{

    public static void main(String[] args) throws InterruptedException{

        ArrayList<Integer> primenb = new ArrayList<>();
        ArrayList<Integer> randomnb = new ArrayList<>();
        ArrayList<Thread> threadlist = new ArrayList<>();
        int threadnb = 2;
        int randnb = 20;
        Random random = new Random();



      for(int i=0;i<randnb;i++) {
          randomnb.add(random.nextInt(100));
      }



        for(int i=0;i<threadnb;i++){
            threadlist.add(new RandomNumbers(primenb,randomnb,(i*randnb)/threadnb,((i+1)*randnb)/threadnb));
        }
        long startTime = System.nanoTime();
        for(int i=0;i<threadlist.size();i++){
            threadlist.get(i).start();

        }
        for(int i=0;i<threadlist.size();i++){
            threadlist.get(i).join();
        }
        long time = System.nanoTime() - startTime;
        System.out.println("Threads: " + threadlist.size() + " Time: " + time/1000 + " us");
        System.out.println("Random List: " + randomnb + "\nPrime list: " + primenb);

    }
}
