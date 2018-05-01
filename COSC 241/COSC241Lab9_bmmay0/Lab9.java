import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This programs consists of the code for Lab 9
 * 
 * @author Bryan May
 * @version 2018.04.30
 */
public class Lab9{
    /**
     * Main method where the other two methods called
     * 
     * @param args Console input
     */
    public static void main(String[] args) {
        Stack<Integer> stackOfIntegers1 = new Stack<>();

        stackOfIntegers1.addAll(Arrays.asList(1, 3, 5, 7, 9));

        Stack<Integer> stackOfIntegers2 = new Stack<>();

        stackOfIntegers2.addAll(Arrays.asList(12, 24, 36, 48, 60));

        Stack<Integer> stackOfIntegers3 = new Stack<>();

        stackOfIntegers3.addAll(Arrays.asList(12, 13, 14, 15, 16));

        mirror(stackOfIntegers1);
        mirror(stackOfIntegers2);

        reverse(stackOfIntegers3, 3);
    }

    /**
     * Method that takes a stack of integers and prints the stack followed by its reverse
     * 
     * e.g. [a, b, c] -> [a, b, c, c, b, a]
     * 
     * @param stackOfIntegers the stack of integers
     * @throws IllegalArgumentException if the stack is null
     */
    public static void mirror(Stack<Integer> stackOfIntegers) throws IllegalArgumentException{
        if(stackOfIntegers == null){
            throw new IllegalArgumentException();
        }
        else{
            Queue<Integer> queueOfIntegers = new LinkedList<>();
            Stack<Integer> backupStack = new Stack<>();
            
            // Empty the contents into a queue and a backup Stack
            while(!stackOfIntegers.isEmpty()){
                int currentInt = stackOfIntegers.pop();

                queueOfIntegers.add(currentInt);
                backupStack.push(currentInt);
            }

            // Reconstruct the original stack
            while(!backupStack.isEmpty()){
                stackOfIntegers.push(backupStack.pop());
            }

            // Add the elements of the queue to the top of the stack
            while(!queueOfIntegers.isEmpty()){
                stackOfIntegers.push(queueOfIntegers.remove());
            }

            System.out.println(stackOfIntegers);
        }
    }

    /**
     * Method that takes a stack of integers and an integer 
     * and prints the first n terms reversed behind the (n + 1) to last term
     * 
     * e.g. [a, b, c, d, e] may become [d, e, c, b, a] if n = 3
     * 
     * @param stackOfIntegers the stack of integers
     * @param n first n terms of the stack
     * @throws IllegalArgumentException if the stack is null
     */
    public static void reverse(Stack<Integer> stackOfIntegers, int n) throws IllegalArgumentException{
        if(stackOfIntegers == null){
            throw new IllegalArgumentException();
        }
        else{
            Stack<Integer> reverseStack = new Stack<>();
            Queue<Integer> queueOfIntegers = new LinkedList<>();
            Stack<Integer> miniStack = new Stack<>();
 
            // Empty the stack into a different stack
            // Which reverses the order
            while(!stackOfIntegers.isEmpty()){
                int currentInt = stackOfIntegers.pop();

                reverseStack.push(currentInt);
            }

            // Empty the new stack into a quere
            while(!reverseStack.isEmpty()){
                int currentInt = reverseStack.pop();

                queueOfIntegers.add(currentInt);
            }

            // Put the first n terms into a stack
            // Which will reverse the order of just those elements
            for(int i = 0; i < n; i++){
                int currentInt = queueOfIntegers.remove();

                miniStack.add(currentInt);
            }

            // Add the miniStack to the remainder of the queue
            while(!miniStack.isEmpty()){
                int currentInt = miniStack.pop();

                queueOfIntegers.add(currentInt);
            }

            System.out.println(queueOfIntegers);
        }
    }
}