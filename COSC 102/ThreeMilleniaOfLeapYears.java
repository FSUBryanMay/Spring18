import java.util.ArrayList;

public class ThreeMilleniaOfLeapYears{
    public static void main(String[] args) {
        ArrayList<Integer> leapYears = new ArrayList();

        for(int i = 1000; i <= 4000; i++){
            if(isLeapYear(i)){
                leapYears.add(i);
            }
        }

        System.out.println(leapYears);
    }

    public static boolean isLeapYear(int year){
        if(year % 4 == 0){
            if(year % 400 == 0){
                return true;
            }
            else if(year % 100 == 0){
                return false;
            }

            return true;
        }

        return false;
    }
}