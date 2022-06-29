import java.util.Random;

public class ArrayUtils {
    // Genereates an array of random ints of a given size
    public int[] randomArray(int size) {
        // Handling invalid inputs
        if (size <= 0) {
            return null;
        }

        Random rand = new Random(System.currentTimeMillis());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(256);
        }
        return arr;
    }

    // Prints an array of Ints
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n");
    }
    
    // Gets the smallest number in an array of ints
    public int minArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public int[] arrayBetweenIndices(int begin, int end, int[] arr) {
        // Test if input is valid
        if (begin < 0 || end > arr.length || begin > end) {
            return null;
        }

        // Initializing the array
        int size = end - begin + 1;
        int[] retArr = new int[size];

        // Filling up the array
        for (int i = 0; i < size; i++, begin++) {
            retArr[i] = arr[begin];
        }
        return retArr;
    }

    public String toString(int[] arr) {
        String output = new String();
        if (arr == null) {
            return "empty";
        }
        for (int i = 0; i < arr.length; i++) {
            output += arr[i];
            output += " ";
        }
        output += "\n";
        return output;
    }
}
