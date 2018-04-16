import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This program searches a dicitionary file for all the anagrams of a user inputted word
 * 
 * @author Bryan May
 * @version 2018.04.16
 */
public class Project1{
    public static void main(String[] args) throws FileNotFoundException{
        prompt();

        Scanner console = new Scanner(System.in);
        String dictionaryFile = console.nextLine();

        Scanner dictionaryScanner = new Scanner(new File(dictionaryFile));

        Map<String, String> wordToSortedWord = new TreeMap<>();

        convertDictionaryToCanonical(dictionaryScanner, wordToSortedWord);

        System.out.println("Word to scramble (Enter N or n to quit):");

        String wordOrQuit = console.next();

        // As long as the exit code isn't keyed in,
        // The program will continue to accept words
        // And print the anagrams
        while(!wordOrQuit.equals("N") && !wordOrQuit.equals("n")){

            if(wordToSortedWord.keySet().contains(wordOrQuit)){
                printAnagrams(wordOrQuit, wordToSortedWord);
            }
            else{
                System.out.println("The word does not exist in the dictionary");
            }

            System.out.println("Word to scramble (Enter N or n to quit):");
            
            wordOrQuit = console.next();
        }

        console.close();
        dictionaryScanner.close();
    }

    /**
     * Introduction prompt of program
     */
    public static void prompt(){
        System.out.println("Welcome to Bryan May's anagram solver.");
        System.out.println("Please enter the dictionary file you want to use:");
    }

    /**
     * Constructs a map mapping dictionary entries to their canonical forms
     * 
     * @param dictionaryScanner Scanner that reads the dictionary file
     * @param wordToSortedWord Map that contains dictionary entries to canonical forms pairings
     */
    public static void convertDictionaryToCanonical(Scanner dictionaryScanner, Map<String, String> wordToSortedWord){
        while(dictionaryScanner.hasNext()){
            String word = dictionaryScanner.next();

            TreeSet<Character> wordSortedLetters = new TreeSet<>();

            for(int i = 0; i < word.length(); i++){
                wordSortedLetters.add(word.charAt(i));
            }

            String sortedWord = "";

            Iterator itr = wordSortedLetters.iterator();

            while(itr.hasNext()){
                sortedWord += itr.next();
            }

            wordToSortedWord.put(word, sortedWord);
        }
    }

    /**
     * Prints n >= 0 anagrams
     * 
     * @param wordToSortedWord Map that contains dictionary entries to canonical forms pairings
     */
    public static void printAnagrams(String wordOrQuit, Map<String, String> wordToSortedWord){
        System.out.println("All words found in \"" + wordOrQuit + "\":");

        for(String key: wordToSortedWord.keySet()){
            if(wordToSortedWord.get(key).equals(wordToSortedWord.get(wordOrQuit)) && key.length() == wordOrQuit.length()){
                System.out.println(key);
            }
        }
    }
}