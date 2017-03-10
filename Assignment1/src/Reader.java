

import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;

public class Reader {

   static public String readFile(String fileName){



       String fileLine = null;
       File file = new File(fileName);
       FileReader fileRead = null;

       try {
           fileRead = new FileReader(file);

           char[] num = new char[(int) file.length()];

           fileRead.read(num);

           fileLine = new String(num);
           fileRead.close();


       } catch (FileNotFoundException fx){

           System.out.println("File Cannot Be Found");
       }
       catch (IOException ex) {

           System.out.println("Input and Output not found");
       }


       return fileLine;

    }



}
