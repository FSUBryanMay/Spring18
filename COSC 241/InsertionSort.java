import java.util.ArrayList;
import java.util.Random;

public class InsertionSort{
    public static void main(String[] args) {
        Random rng = new Random();
        ArrayList<Integer> integers = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            integers.add(rng.nextInt(50));
        }

        System.out.println(integers);
        System.out.println(insertionSort(integers));
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integers){
        for(int i = 1; i < integers.size(); i++){
            int temp = integers.get(i);
            integers.remove(i);

            for(int j = 0; j < integers.size(); j++){
                if(temp > integers.get(j)){
                    continue;
                }
                else{
                    integers.add(j, temp);
                    break;
                }
            }
        }

        return integers;
    }
}