import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by amacavei on 7/28/2015.
 */
public class Main {

    public static void main(String[] args) throws IOException,InterruptedException {
        Path file = Paths.get("Strings.txt");
        String line;


        ArrayList<Thread> threadlist = new ArrayList<>();
        int threadnb = 4;

        InputStream in = Files.newInputStream(file);
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));
            line = rd.readLine();
            String[] words = line.split(" ");


            for (int i = 0; i < threadnb; i++) {
                threadlist.add(new FilePercentage(file,(i * words.length) / threadnb, ((i + 1) * words.length) / threadnb));
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < threadlist.size(); i++) {
                threadlist.get(i).start();

            }
            for (int i = 0; i < threadlist.size(); i++) {
                threadlist.get(i).join();
            }
            long time = System.nanoTime() - startTime;

            if(rd != null) {
                rd.close();
            }


        System.out.println("Threads: " + threadlist.size() + " Time: " + time/1000 + " us");
    }
}
