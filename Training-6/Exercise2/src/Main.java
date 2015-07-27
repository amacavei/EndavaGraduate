import java.io.*;
import java.util.Scanner;

/**
 * Created by amacavei on 7/26/2015.
 */
public class Main{

    public static void main(String[] args){

        FileOperations addString = new FileOperations();

        try {
            addString.addToMap();
            addString.printMap();

        }catch(Exception e){}



    }
}
