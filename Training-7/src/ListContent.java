import java.io.File;
import java.io.IOException;
import java.util.*;

import java.io.FileWriter;

/**
 * Created by amacavei on 7/27/2015.
 */
public class ListContent {

    public List<String> filenames = new ArrayList<String>();
    File[] listoffiles = new File("D:\\Perso").listFiles();
    File list = new File("D:\\Perso\\List.txt");

    public ListContent() {
    }

    public void listContent() throws IOException {
        //pptx Filter:

        String ext = "pptx";
        for (File files : listoffiles) {
            String fname = files.getName();
            if (fname.substring(fname.lastIndexOf(".")+1).equals(ext)) {
                filenames.add(files.getName());

                if (files.isFile()) {
                    System.out.println("File: " + files.getName());


                } else if (files.isDirectory()) {
                    System.out.println("Directory: " + files.getName());
                }

            }
            System.out.println("\n\nList of files: \n\n");

            Collections.sort(filenames, new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            });

            System.out.println(filenames);


            FileWriter writename = new FileWriter(list);

            for (String name : filenames) {
                writename.write("" + name + System.getProperty("line.separator"));

            }
            writename.close();
        }
    }

    public static void main(String[] args) throws IOException{

        ListContent list = new ListContent();
        list.listContent();


    }


}
