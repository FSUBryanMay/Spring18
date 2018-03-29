import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Program1{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner textScanner = new Scanner(new File("words.txt"));
        Scanner console = new Scanner(System.in);

        System.out.println("Please type in two words:");

        String word1 = console.next();
        String word2 = console.next();
        ArrayList<String> wordsAsList = new ArrayList();

        while(textScanner.hasNextLine()){
            wordsAsList.add(textScanner.next());
        }

        if(Collections.binarySearch(wordsAsList, word1) >= 0 && Collections.binarySearch(wordsAsList, word2) >= 0){
            int numberOfWordsBetween = Math.abs(Collections.binarySearch(wordsAsList, word1) - Collections.binarySearch(wordsAsList, word2));

            System.out.println("There are " + numberOfWordsBetween + " words between " + word1 + " and " + word2);
        }
        else{
            System.out.println("Either " + word1 + ", " + word2 + ", or both were not found");
        }
    }
}