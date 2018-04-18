import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Lab7{
    /**
     * Main method
     * 
     * @param args For command line input
     */
    public static void main(String[] args) {
        // Method call for writeSequence
        writeSequence(10);

        System.out.println();

        // Method call for permutation
        System.out.println(permutation(5, 2));

        Map<String, String> mapOfStrings = new TreeMap<>();
        mapOfStrings.put("1", "One");
        mapOfStrings.put("2", "Two");
        mapOfStrings.put("3", "Three");

        // Print the origial map
        // And then the reverse
        System.out.println(mapOfStrings);
        System.out.println(reverse(mapOfStrings));
    }

    /**
     * This method prints a symmetric sequence of n numbers
     * composed of descending integers that ends in 1
     * followed by a sequence of ascending integers that begins with 1
     * 
     * @param n inputted positive integer
     */
    public static void writeSequence(int n){
        // If n is 1
        // Print 1
        if(n == 1){
            System.out.print("1 ");
        }
        // If n is 2
        // Print 1 1
        else if(n == 2){
            System.out.print("1 1 ");
        }
        // Any other value is just writeSequence(n - 2)
        // With (n / 2) + (n % 2) bookend on both ends
        else {
            System.out.print(((n / 2) + (n % 2)) + " ");
            writeSequence(n - 2);
            System.out.print(((n / 2) + (n % 2)) + " ");
        }
    }

    /**
     * This method accepts two integers n and r as parameters
     * And returns the number of unique permutations of r items from a group of n items.
     * 
     * @param n inputted integer
     * @param r inputted integer
     * @return number of unique permutations of r items from a group of n items.
     */
    public static int permutation(int n, int r) throws IllegalArgumentException{
        // By rules of permutation,
        // r can't be greater than n
        if(n < r){
            throw new IllegalArgumentException("n cannot be less than r");
        }
        // Also by permutation rules,
        // r can't be less than 0,
        // so 0 is the base case
        else if(r == 0){
            return 1;
        }
        // P(n, r) is n * P(n - 1, r - 1)
        else{
            return n * permutation(n - 1, r - 1);
        }
    }

    /**
     * This accepts a map from strings to strings as a parameter
     * and returns a new map that is the reverse of the original
     * 
     * @param mapOfStrings the original map
     * @return the reverse of the original map
     */
    public static Map<String, String> reverse(Map<String, String> mapOfStrings){
        // A new empty map to hold the reverse pairs
        Map<String, String> reverseMap = new TreeMap<>();
        // An Iterator item to traverse the keySet of the original map
        Iterator<String> itr = mapOfStrings.keySet().iterator();
        
        // Grab the key
        // And set the value as the new key
        // And the old key as the new value
        while(itr.hasNext()){
            String key = itr.next();
            reverseMap.put(mapOfStrings.get(key), key);
        }

        return reverseMap;
    }
}
