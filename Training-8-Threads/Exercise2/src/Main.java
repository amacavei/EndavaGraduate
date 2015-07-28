import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Created by amacavei on 7/28/2015.
 */
public class Main {

    public static void main(String[] args) throws IOException{
        Path file = Paths.get("Strings.txt");
        FilePercentage filePercentage = new FilePercentage(file);
       // filePercentage.split = new LinkedList<>();
        filePercentage.copyString();
    }
}
