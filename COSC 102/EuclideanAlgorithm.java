import java.util.Scanner;

public class EuclideanAlgorithm{
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Please enter two nonnegative integers");

        int a = console.nextInt();
        int b = console.nextInt();

        console.close();

        System.out.println("The GCD of " + a + " and " + b + " is " + gcd(a, b));
    }

    public static int gcd(int a, int b){
        int m = 0;
        int n = 0;

        if(a > b){
            m = b;
            n = a;
        }
        else{
            m = a;
            n = b;
        }

        if(a == 0){
            return b;
        }
        else{
            return gcd(n % m, a);
        }
    }
}