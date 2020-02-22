import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopyingFile {

    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String fileName;
        File file;

        while (true){
            System.out.println("Enter file name/directory: ");
            fileName = scanner.nextLine();
            file = new File(fileName);
            try {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()){
                    System.out.println(scanner.nextLine());
                }
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Sorry file not found");
                continue;
            }
        }
    }
    //done in 30 minutes
}
