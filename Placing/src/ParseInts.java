// ****************************************************************
// ParseInts.java
//
// Reads a line of text and prints the integers in the line.
//
// ****************************************************************
import java.util.Scanner;
public class ParseInts
{
    public static void main(String[] args)
    {
        int val, sum=0;
        Scanner scan = new Scanner(System.in);
        String line;
        System.out.println("Enter a line of text");
        Scanner scanLine = new Scanner(scan.nextLine());

        //answer for number 1
//        try {
//            while (scanLine.hasNext())
//            {
//                val = Integer.parseInt(scanLine.next());
//                sum += val;
//            }
//        } catch (NumberFormatException e){
//
//        }

        //answer for number 2
        while (scanLine.hasNext())
        {
            try {
                val = Integer.parseInt(scanLine.next());
                sum += val;
            } catch (NumberFormatException e) {
                continue;
            }
        }
        System.out.println("The sum of the integers on this line is " + sum);
    }
    //done in 5 minutes
}