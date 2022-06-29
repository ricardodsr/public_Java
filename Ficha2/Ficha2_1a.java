import java.util.Scanner;

public class Ficha2_1a {
    public static void main (String[] args) {
        // Utilities needed
        ArrayUtils au = new ArrayUtils();
        Scanner scanner = new Scanner(System.in);

        // Getting a size for the array and declaring it
        System.out.println("Non-positive inputs will generate a random array!");
        System.out.println("Choose an array size (int):");
        int size = scanner.nextInt();
        int[] arr;

        if (size > 0) {
            // Initializing array and filling it up
            arr = new int[size];
            System.out.println("Enter " + size + " integers, one at a time: ");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
        } else {
            // Generating a randomArray of size 10 and saving it in 'arr'
            size = 10;
            arr = au.randomArray(size);
        }

        System.out.println("This ir your array:");
        au.printArray(arr);

        // Getting the minimum of the array and printing it in the chat
        int min = au.minArray(arr);
        System.out.printf("The minimum in the array is: %d\n", min);
    }
}
