package company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public static void read(String filename) {

        String line = null;

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println( "Unable to open file '" + filename + "'");
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + filename + "'");
        }
    }
}