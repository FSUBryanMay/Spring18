import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSearch{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));

        System.out.println(selectionSearch(list, 6));
    }

    public static int selectionSearch(ArrayList<Integer> list, int targetValue){
        for(int i = 0; i < list.size(); i++){
            if(targetValue == list.get(i)){
                return i;
            }
        }

        return -1;
    }
}