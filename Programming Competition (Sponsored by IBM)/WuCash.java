import java.util.Scanner;

public class WuCash{
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("$");

        while(console.hasNextInt()){
            

            int wuCashCoin = console.nextInt();

            System.out.println("W" + dollarsToWuCash(wuCashCoin));
            System.out.print("$");
        }

        console.close();
    }

    public static int dollarsToWuCash(int wuCashCoin){
        if(wuCashCoin <= 11){
            return wuCashCoin;
        }
        else{
            return dollarsToWuCash(wuCashCoin / 2) + dollarsToWuCash(wuCashCoin / 3) + dollarsToWuCash(wuCashCoin / 4);
        }
    }
}