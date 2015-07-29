import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

/**
 * Created by amacavei on 7/28/2015.
 */
public class FilePercentage extends Thread{

    //public String word;
    public Path pathfile;
    BufferedReader rd = null;
    public LinkedList<String> split = new LinkedList<>();
    String line;
    int occ;
    int startIndex;
    int endIndex;

    public FilePercentage(Path pathfile,int startIndex,int endIndex){

        this.pathfile = pathfile;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public String[] splitString(String str){

        return str.split(" ");
    }

    public float percOcc(float o,float len){

        return (o/len)*100;
    }

    @Override
    public void run(){

        try (InputStream in = Files.newInputStream(pathfile);
             BufferedReader rd = new BufferedReader(new InputStreamReader(in))){
                line = rd.readLine();
                String[] words = splitString(line);

                for(int i=startIndex;i<endIndex;i++) {
                    this.split.add(words[i]);
                }

            for(String items:split) {
                occ = 0;
                for (int i = startIndex; i < endIndex; i++) {
                     occ = wordOcc(items,words[i]);
                }
                System.out.printf("%s %.1f\n",items,percOcc((float)occ,(float)words.length));
            }
            System.out.println(split);

        }
        catch(Exception e){}
        finally {
            if(rd != null) {
                try {
                    rd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public synchronized int wordOcc(String word1,String word2){

        if(word1.equals(word2)){
            occ++;
        }
        return occ;
    }
}
