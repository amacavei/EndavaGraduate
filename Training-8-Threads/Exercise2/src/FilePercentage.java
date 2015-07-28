import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

/**
 * Created by amacavei on 7/28/2015.
 */
public class FilePercentage {

    public String word;
    public Path pathfile;
    BufferedReader rd = null;
    public LinkedList<String> split = new LinkedList<>();
    String line;
    int occ;

    public FilePercentage(Path pathfile){
        this.pathfile = pathfile;
    }

    public String[] splitString(String str){
        return str.split(" ");
    }

    public float percOcc(float o,float len){

        return (o/len)*100;
    }

    public void copyString() throws IOException{

        try (InputStream in = Files.newInputStream(pathfile);
             BufferedReader rd = new BufferedReader(new InputStreamReader(in))){
                line = rd.readLine();
                String[] words = splitString(line);

                for(int i=0;i<words.length;i++) {
                    this.split.add(words[i]);
                }

            for(String items:split) {
                occ = 0;
                for (int i = 0; i < words.length; i++) {
                     occ = wordOcc(items,words[i]);
                }
                System.out.printf("%s %.1f\n",items,percOcc((float)occ,(float)words.length));
            }
            System.out.println(split);

        } finally {
            if(rd != null) {
                rd.close();
            }
        }
    }
    public int wordOcc(String word1,String word2){

        if(word1.equals(word2)){
            occ++;
        }
        return occ;
    }
}
