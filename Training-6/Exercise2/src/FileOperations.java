import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.util.*;

/**
 * Created by amacavei on 7/24/2015.
 */
public class FileOperations {
    String name;
    HashMap < String, ArrayList<TVSeries>> TVProgram = new HashMap<>();
    ArrayList<TVSeries> tvSeries = new ArrayList<>();


    public String getKey(String key)
    {
        if(TVProgram.containsKey(key))
        {
            return key;
        }
        return null;
    }
    public FileOperations() {
    }

    public void addToMap() throws FileNotFoundException,IOException {


        FileReader fr = new FileReader("C:\\Users\\amacavei\\IdeaProjects\\TrainingCollections\\Exercise2\\src\\info.txt");
        BufferedReader read = new BufferedReader(fr);
        String s;
        while((s = read.readLine()) != null) {

            String[] line = s.split("-");
            TVSeries seriesItem = new TVSeries(line[1],line[2],line[3],line[4],line[5]);
            System.out.println(s + " " + line[0] + " " + getKey(line[0]));

            if(!TVProgram.containsKey(line[0])) {

                    TVProgram.put(line[0], this.tvSeries);
                    tvSeries.add(0, seriesItem);
            }
            else if(TVProgram.containsKey(line[0])){



            }
        }
        fr.close();
    }

    public void printMap(){
        final Set set = TVProgram.entrySet();
        final Iterator i = set.iterator();

        while(i.hasNext()) {
            final Map.Entry me = (Map.Entry) i.next();
            System.out.println("HashMapValues :" + " " + me.getKey() + " " + me.getValue());
        }
    }
}



