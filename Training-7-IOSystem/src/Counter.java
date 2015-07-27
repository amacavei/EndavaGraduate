import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by amacavei on 7/27/2015.
 */
public class Counter {

    BufferedWriter wrt = null;
    BufferedReader rd = null;
    public char find;
    public String pathfile;
    public String c;
    String line = null;

    public Counter(char find, String pathfile) {
        this.find = find;
        this.pathfile = pathfile;
    }

    public int countApp(String c) throws IOException {
        int app = 0;
        try {
            wrt = new BufferedWriter(new FileWriter(pathfile));
            wrt.write("" + Integer.parseInt(c) + "\n");
            wrt.flush();
            rd = new BufferedReader(new FileReader(pathfile));
            while((line = rd.readLine())!=null) {
                System.out.println(line);
                for (int i = 0; i < line.length(); i++) {
                    if (find == line.charAt(i)) {
                        app ++;
                    }
                }
            }
        } finally {
            if(wrt != null) {
                wrt.close();
            }
            if(rd != null) {
                rd.close();
           }
        }
        return app;
    }

    public static void main(String[] args) throws IOException{

        Counter count = new Counter('1',"D:\\Perso\\charstring.txt");
        System.out.println(count.countApp("1111112222"));

    }
}
