import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lab8{
    public static void main(String[] args){
        ArrayList<Integer> listOfIntegers = new ArrayList<>();

        listOfIntegers.addAll(Arrays.asList(15, 1, 6, 12, -3, 4, 8, 21, 2, 30, -1, 9));

        System.out.println("List of integers before rearrangement " + listOfIntegers);
        System.out.println("List of integers after rearrangement " + separation(listOfIntegers, 5));

        Set<Integer> set1 = new TreeSet<>();

        set1.addAll(Arrays.asList(1, 4, 7, 9));

        Set<Integer> set2 = new TreeSet<>();

        set2.addAll(Arrays.asList(2, 4, 5, 6, 7));

        System.out.println("The symmetric difference between " + set1 + " and " + set2 + " is " + symmetricSetDifference(set1, set2));
    }

    public static List<Integer> separation(List<Integer> listOfIntegers, int x){
        ArrayList<Integer> rearrangedInts = new ArrayList<>();

        int listSize = listOfIntegers.size();

        for(int i = 0; i < listSize; i++){
            int currentInt = listOfIntegers.get(i);
            
            if(currentInt < x){
                rearrangedInts.add(0, currentInt);
            }
            else {
                rearrangedInts.add(currentInt);
            }
        }

        return rearrangedInts;
    }

    public static Set<Integer> symmetricSetDifference(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> symmetricDifference = new TreeSet<>();

        symmetricDifference.addAll(set1);
        symmetricDifference.addAll(set2);

        Iterator<Integer> itr = symmetricDifference.iterator();

        while(itr.hasNext()){
            int currentInt = itr.next();

            if(set1.contains(currentInt) && set2.contains(currentInt)){
                itr.remove();
            }
        }

        return symmetricDifference;
    }
}