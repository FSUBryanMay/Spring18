public class Program1{
    public static void main(String[] args) {
        System.out.println(doubleDigits(-789));
        writeChars(17);
        System.out.println();
    }

    public static int doubleDigits(int n){
        if(n < 0){
            return -1 * doubleDigits(Math.abs(n));
        }
        else if(n < 10){
            return 11 * n;
        }
        else{
            int a = doubleDigits(n / 10);
            int b = doubleDigits(n % 10);

            return (100 * a) + b;
        }
    }

    public static void writeChars(int n){
        if(n < 1){
            throw new IllegalArgumentException();
        }
        else if(n == 1){
            System.out.print("*");   
        }
        else if(n == 2){
            System.out.print("**");  
        }
        else{
            System.out.print("<");
            writeChars(n - 2);
            System.out.print(">");
        }
    }
}