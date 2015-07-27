import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Created by amacavei on 7/27/2015.
 */
public class ReadLine {
    BufferedReader rd = null;
    public Path pathfile;
    public String line;
    public LinkedList<String> linelist = new LinkedList<>();


    public ReadLine(Path pathfile) {
        this.pathfile = pathfile;
    }

    public void copyString() throws IOException{

    try (InputStream in = Files.newInputStream(pathfile);
         BufferedReader rd = new BufferedReader(new InputStreamReader(in))){

        while((line = rd.readLine())!=null) {
            this.linelist.add(line);
        }
    } finally {
        if(rd != null) {
            rd.close();
        }
    }

}

    public static void main(String[] args) throws IOException{

        Path file = Paths.get("Strings.txt");
        ReadLine read = new ReadLine(file);
        read.linelist = new LinkedList<>();
        read.copyString();
        for(int i=0;i< read.linelist.size();i++){
            System.out.println(read.linelist.get(i));
        }

    }
}
