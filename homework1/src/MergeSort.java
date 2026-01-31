package homework1.src;

import java.util.LinkedList;
import java.util.Random;


public class MergeSort {

    public static void main(String[] args) {

        int[] input = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            input[i] = rand.nextInt(5000);
        }

        mergeSort(input);

    }

    /**
     * helper function to merge two sorted arrays 
     * @param: int[] left array
     *         int[] right array
     * @return: the combined sorted array
     */
   
    public static int[] mergeHelper(int[] left, int[] right) {

        // create the int array to store sorted result
        int[] result = new int[left.length + right.length];

        int i = 0;  // left index
        int j = 0;  // right index
        int k = 0;  // result index

        while (i < left.length && j < right.length) {
            // compare the front element and add the smaller element to result
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
                k++;
            } else {
                result[k] = right[j];
                j++;
                k++;
            }
        }
        
        // when left array has remainings 
        while (i < left.length) {
            // add the left array in order to the result
            result[k] = left[i];
            ++i;
            ++k;
        }

        // when rigth array has remainings 
        while (j < right.length) {
            // add the right array in order to the result
            result[k] = right[j];
            ++j;
            ++k;
        }

        return result;   
    }

    public static int[] mergeSort(int[] input) {

        // single int is sorted
         if (input.length <= 1) {            
            return input;   
        }

        // split arrays
        int left_len = input.length/2;
        int right_len = input.length - left_len;

        int[] left = new int[left_len];
        int[] right = new int[right_len];

        // add elements to both arrays
        for (int i = 0; i < left_len; ++i) {
            left[i] = input[i];
        }
        for (int j = 0; j < right_len; ++j) {
            right[j] = input[left_len + j];
        }

        // recursively split arrays
        left = mergeSort(left);
        right = mergeSort(right);

        // return the sorted arrays
        return mergeHelper(left, right);
    }
}

