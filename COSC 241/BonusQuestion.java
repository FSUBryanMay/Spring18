import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class BonusQuestion{
    public static void main(String[] args) {
        ArrayList<Integer> listOfInts = new ArrayList<>();
        Random rng = new Random();

        for(int i = 0; i < 20; i++){
            listOfInts.add(rng.nextInt(10));
        }

        System.out.println("The number of times the most frequent number occurs in " + listOfInts + " is " + maxOccur(listOfInts));
    }

    public static int maxOccur(List<Integer> integers){
        Map<Integer, Integer> intTallies = new TreeMap<>();

        for(int integer : integers){
            intTallies.put(integer, 0);
        }

        for(int i = 0; i < integers.size(); i++){
            intTallies.put(integers.get(i), intTallies.get(integers.get(i)) + 1);
        }

        System.out.println(intTallies);

        int mostFrequent = 0;

        for(int integer : intTallies.keySet()){
            if(intTallies.get(integer) > mostFrequent){
                mostFrequent = intTallies.get(integer);
            }
        }

        return mostFrequent;
    }
}