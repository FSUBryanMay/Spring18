import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));

        System.out.println(binarySearch(list, 1));
    }

    public static int binarySearch(ArrayList<Integer> list, int targetValue){
        int min = 0;
        int mid = list.size() / 2;
        int max = list.size();

        boolean targetFound = false;

        while(!targetFound){
            if(targetValue == list.get(mid)){
                targetFound = true;

                return mid;
            }
            else if(targetValue < list.get(mid)){
                max = mid;
                mid = (min + max) / 2;
            }
            else{
                min = mid;
                mid = (min + max) / 2;
            }
        }

        return -1;
    }
}