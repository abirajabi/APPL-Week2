// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;
public class Warning
{
    // --------------------------------------------------------------------
// Reads student data (name, semester hours, quality points) from a
// text file, computes the GPA, then writes data to another file
// if the student is placed on academic warning.
// --------------------------------------------------------------------
    public static void main (String[] args)
    {
        int creditHrs; // number of semester hours earned
        double qualityPts; // number of quality points earned
        double gpa; // grade point (quality point) average
        String line, name, inputName = "D:\\Naufal\\_POLBAN\\Kuliah\\SMT_4\\APPL\\ReadingAndWritingTextFile\\students.dat";
        String outputName = "D:\\Naufal\\_POLBAN\\Kuliah\\SMT_4\\APPL\\ReadingAndWritingTextFile\\warning.dat";
        Scanner scan;
        PrintWriter outFile;

        File file = new File(inputName);
        try
        {
// Set up scanner to input file
            scan = new Scanner(file);
// Set up the output file stream
            outFile = new PrintWriter(outputName);
// Print a header to the output file
            outFile.println ();
            outFile.println ("Students on Academic Warning");
            outFile.println ();
// Process the input file, one token at a time
            while ()
            {
// Get the credit hours and quality points and
// determine if the student is on warning. If so,
// write the student data to the output file.
            }
// Close output file
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("The file " + inputName + " was not found.");
        }
        catch (IOException exception)
        {
            System.out.println (exception);
        }
        catch (NumberFormatException e)
        {
            System.out.println ("Format error in input file: " + e);
        }
    }
    //pended on minutes 9
}