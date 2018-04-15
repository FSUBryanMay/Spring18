import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project1{
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("Welcome to Bryan May's anagram solver.");
        System.out.println("Please enter the dictionary file you want to use:");

        Scanner console = new Scanner(System.in);
        String dictionaryFile = console.nextLine();

        Scanner dictionaryScanner = new Scanner(new File(dictionaryFile));

        ArrayList<String> dictionaryList = new ArrayList<>();

        while(dictionaryScanner.hasNext()){
            String word = dictionaryScanner.next();
            dictionaryList.add(word);
        }
        
        System.out.println("Word to scramble (Enter N or n to quit):");

        String wordOrQuit = console.next();
        while(!wordOrQuit.equals("N") && !wordOrQuit.equals("n")){
            if(!dictionaryList.contains(wordOrQuit)){
                System.out.println("The word does not existed in the dictionary");
            }
            else{

            }

            System.out.println("Word to scramble (Enter N or n to quit):");
            wordOrQuit = console.next();
        }
    }
}