import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {


        ArrayList<Product> prods= new ArrayList<>();
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);
                System.out.printf("%-20s%-20s%-20s%-20s\n","ID", "Name","Description","Cost");
                String dashLine = "-".repeat(20 * 4);
                System.out.printf("%s\n", dashLine);
                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();
                    String[] row = line.split(", ");
                    System.out.printf("%-20s%-20s%-20s%-20s\n", row[0], row[1], row[2], row[3]);
                    Double val = Double.parseDouble(row[3]);
                    Product prod = new Product(row[0], row[1], row[2], val);
                    prods.add(prod);

                }

                inFile.close();
            }
            else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}
