import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Lab7{
    public static void main(String[] args) {
        writeSequence(10);

        System.out.println();

        System.out.println(permutation(1, 2));

        Map<String, String> mapOfStrings = new TreeMap<>();
        mapOfStrings.put("1", "One");
        mapOfStrings.put("2", "Two");
        mapOfStrings.put("3", "Three");

        System.out.println(mapOfStrings);
        System.out.println(reverse(mapOfStrings));
    }

    public static void writeSequence(int n){
        if(n == 1){
            System.out.print("1 ");
        }
        else if(n == 2){
            System.out.print("1 1 ");
        }
        else {
            System.out.print(((n / 2) + (n % 2)) + " ");
            writeSequence(n - 2);
            System.out.print(((n / 2) + (n % 2)) + " ");
        }
    }

    public static int permutation(int n, int r) throws IllegalArgumentException{
        if(n < r){
            throw new IllegalArgumentException("n cannot be less than r");
        }
        else if(r == 1){
            return n;
        }
        else{
            return n * permutation(n - 1, r - 1);
        }
    }

    public static Map<String, String> reverse(Map<String, String> mapOfStrings){
        Map<String, String> reverseMap = new TreeMap<>();
        Iterator<String> itr = mapOfStrings.keySet().iterator();
        
        while(itr.hasNext()){
            String key = itr.next();
            reverseMap.put(mapOfStrings.get(key), key);
        }

        return reverseMap;
    }
}
