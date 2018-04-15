import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Project1{
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("Welcome to Bryan May's anagram solver.");
        System.out.println("Please enter the dictionary file you want to use:");

        Scanner console = new Scanner(System.in);
        String dictionaryFile = console.nextLine();

        Scanner dictionaryScanner = new Scanner(new File(dictionaryFile));

        Map<String, String> wordToSortedWord = new TreeMap<>();

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

        System.out.println("Word to scramble (Enter N or n to quit):");

        String wordOrQuit = console.next();
        while(!wordOrQuit.equals("N") && !wordOrQuit.equals("n")){
            if(wordToSortedWord.keySet().contains(wordOrQuit)){
                System.out.println("All words found in \"" + wordOrQuit + "\":");

                for(String key: wordToSortedWord.keySet()){
                    if(wordToSortedWord.get(key).equals(wordToSortedWord.get(wordOrQuit)) && key.length() == wordOrQuit.length()){
                        System.out.println(key);
                    }
                }
            }
            else{
                System.out.println("The word does not exist in the dictionary");
            }

            System.out.println("Word to scramble (Enter N or n to quit):");
            
            wordOrQuit = console.next();
        }
    }
}