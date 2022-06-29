import java.util.Scanner;

public class Ficha2_1b {
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

        System.out.println("This is your array:");
        au.printArray(arr);
        
        // Getting the bounds of the new array
        System.out.printf("Choose the 2 indices x and y (x >= 0 && y <= %d)\n", size);
        System.out.printf("Input value of x: ");
        int x = scanner.nextInt();
        System.out.printf("Input value of y: ");
        int y = scanner.nextInt();

        int arr2[] = au.arrayBetweenIndices(x, y, arr);
        System.out.println("Your new array is:");
        au.printArray(arr2);
    }
}
