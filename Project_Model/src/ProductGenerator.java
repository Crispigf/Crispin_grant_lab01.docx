import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) {


        ArrayList<Product> prods = new ArrayList<>(); //array of people in an array called "folks"
        Scanner in = new Scanner(System.in); //scanner named "in: for system

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");


        boolean done = false; //do while flag

        String ProdRec = "";
        String ID = "";
        String Name = "";
        String Description = "";
        Double Cost = 0.0;

        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID (6 digits)");
            Name= SafeInput.getNonZeroLenString(in, "Enter the name");
            Description = SafeInput.getNonZeroLenString(in, "Enter a description");
            Cost = SafeInput.getRangedDouble(in, "Cost:", 0, 9999 );
            Product prod = new Product(ID, Name,Description,Cost);

            prods.add(prod);

            done = SafeInput.getYNConfirm(in, "Are you done?");

        }while(!done);

        for(Product p: prods)
            System.out.println(p.toCSVDataRecord());


        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Product rec : prods)
            {
                writer.write(rec.toCSVDataRecord(), 0, rec.toCSVDataRecord().length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}