import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class BoatPlanning{
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int numberOfPeople = console.nextInt();

        ArrayList<Integer> rowingTimes = new ArrayList<>();

        for(int i = 0; i < numberOfPeople; i++){
            int rowingTime = console.nextInt();
            rowingTimes.add(rowingTime);
        }

        Collections.sort(rowingTimes);

        int fastestTime = rowingTimes.get(0);

        rowingTimes.remove(0);

        int leastAmountOfTime = 0;

        for(int i = 0; i < rowingTimes.size(); i++){
            leastAmountOfTime +=  rowingTimes.get(i);
        }

        leastAmountOfTime += (fastestTime * (numberOfPeople - 2));

        System.out.println(leastAmountOfTime);
    }
}