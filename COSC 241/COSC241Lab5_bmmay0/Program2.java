import java.util.Random;

public class Program2{
    public static void main(String[] args) {
        Random rng = new Random();
        int[] integers = new int[10];

        for(int i = 0; i < integers.length; i++){
            integers[i] = rng.nextInt(100);
        }

        for(int i = 0; i < integers.length; i++){
            System.out.print(integers[i] + " ");
        }

        System.out.println();

        for(int i = integers.length - 1; i >= 0; i--){
            int max = integers[i];
            int maxIndex = i;

            for(int j = 0; j < i; j++){
                if(integers[j] > max){
                    max = integers[j];
                    maxIndex = j;
                }
            }

            int temp = integers[i];
            integers[i] = integers[maxIndex];
            integers[maxIndex] = temp;
        }

        for(int i = 0; i < integers.length; i++){
            System.out.print(integers[i] + " ");
        }

        System.out.println();
    }
}