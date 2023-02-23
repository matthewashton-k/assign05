package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A class that can sort an arraylist of T using insertionsort, mergesort, or quicksort
 *
 * @author Matthew Ashton-Knochel, Trent Hansen
 */
public class ArrayListSorter {
    static int mergeThresh = 4;
    static int quickThresh = 4;

    /**
     * Sorts a subarray of arr using insertion sort, good for small data sets
     *
     * @param arr the arraylist to be sorted
     * @param l the left most index of the subarray to be sorted (l is INCLUDED)
     * @param r the right most index of the subarrayarray to be sorted (r is EXCLUDED)
     * @param <T> anything that extents comparable
     */
    public static <T extends Comparable<? super T>> void insertionsort(ArrayList<T> arr, int l, int r) {
        for (int i = l+1; i < r; i++) {
            T arrI = arr.get(i);
            int j = i-1;
            // while arr[j] is bigger than arr[i]
            while (j >= l && (arr.get(j).compareTo(arrI)) > 0) {
                // shift list forward
                arr.set(j+1,arr.get(j));
                j--;
            }
            arr.set(j+1, arrI);
        }
    }

    /**
     * the driver function to merge sort arr
     * @param arr arraylist to be sorted
     * @param <T> anything that extends comparable
     */
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
        ArrayList<T> tempArr = new ArrayList<>();
        tempArr.addAll(arr);
        mergesort(tempArr, arr, 0, arr.size());
    }

    /**
     * the recursive private function that will mergesort the array until a threshold where the array is finished being sorted by insertionsort
     * @param tempArr the temparary storage for sorting the left, then right half of the array
     * @param arr the array to be sorted
     * @param l the left side of the array to be sorted
     * @param r the right side of the array to be sorted
     * @param <T> anything that extends comparable
     */
    private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> tempArr, ArrayList<T> arr, int l, int r) {
        if ((r-l)<=mergeThresh) {
            insertionsort(arr, l, r);
            return;
        }
        int middle = (l+r)/2;
        mergesort(tempArr, arr, l, middle);
        mergesort(tempArr, arr, middle, r);
        merge(tempArr, arr, l, r);
    }

    /**
     * the merge portion of the mergesort, combines the left and right side of an array
     *
     * @param tempArr the temp storage space to hold the left and right half of the array
     * @param arr the array to be sorted
     * @param l right side of the array to be merged
     * @param r left index of the array to be merged
     * @param <T> anything that extends comparable
     */
    private static <T extends Comparable<? super T>> void merge(ArrayList<T> tempArr, ArrayList<T> arr, int l, int r) {
        int mid = (l+r)/2;
        int lIndex = l;
        int rIndex = mid;
        int tempIndex = l;

        while (lIndex < mid && rIndex < r) {
            // check which is bigger, then add it to the arr
            if (arr.get(lIndex).compareTo(arr.get(rIndex)) < 0) {
                tempArr.set(tempIndex++, arr.get(lIndex++));
            } else if (arr.get(rIndex).compareTo(arr.get(lIndex)) < 0) {
                tempArr.set(tempIndex++, arr.get(rIndex++));
            } else {
                tempArr.set(tempIndex++, arr.get(lIndex++));
            }
        }

        // check which side has some left and add them to temp
        while (lIndex < mid) {
            tempArr.set(tempIndex, arr.get(lIndex));
            tempIndex++;
            lIndex++;
        }
        while (rIndex < r) {
            tempArr.set(tempIndex, arr.get(rIndex));
            tempIndex++;
            rIndex++;
        }

        // copy the portion of temp array that we merged back to arr
        for (int i = l; i < r; i++) {
            arr.set(i, tempArr.get(i));
        }
    }

    /**
     * this is the public driver function for quicksort
     *
     * @param arr the array to be quicksorted
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
        quicksort(arr, 0, arr.size());
    }

    /**
     * the recursive quicksort function that calls partition
     *
     * @param arr the array to be sorted
     * @param l left index of the array
     * @param r right index of the array
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr, int l, int r) {
        if ((r-l)<=quickThresh) {
            insertionsort(arr, l, r);
            return;
        }
        int pivot = partition(arr, l, r);

        // quicksort the left side of the arr
        quicksort(arr, l, pivot);
        //quicksort the right side of the arr
        quicksort(arr, pivot, r);

    }

    /**
     * the partition portion of quicksort, called by the recursive quicksort()
     * @param arr the array to be partitioned
     * @param l left index of the subarray
     * @param r right index of the subarray
     * @return the index of the pivot
     * @param <T>
     */
    private static <T extends Comparable<? super T>> int partition(ArrayList<T> arr, int l, int r) {

//        Random rand = new Random();

//        int pSpot = rand.nextInt(r-l) + l; //different pivot selection
         int pSpot = (l+r)/2; // different pivot selection
        // int pSpot = r-1; // different pivot selection

        // get the element at pivot
        T pivot = arr.get(pSpot);

        // starts at the left of the array and is moved forward when an element is less than the pivot
        int spot = l;

        // moves the pivot to the end of the array so that it is moved into place last
        swap(arr, pSpot, r-1);

        for (int i = l; i < r; i += 1) {
            // if arr[i] is less than the pivot
            if (arr.get(i).compareTo(pivot) <= 0) {
                swap(arr, i, spot);
                spot++;
            }
        }
        return spot;
    }

    /**
     * generates an ascending list from 0 to size
     * @param size size of list to be generated
     * @return generated list
     */
    public static ArrayList<Integer> generateAscending(int size) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(i);
        }

        return arr;
    }

    /**
     * generates a permuted list containing 0 to size shuffled
     * @param size the size of the list to be generated
     * @return the generated list
     */
    public static ArrayList<Integer> generatePermuted(int size) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);

        return arr;
    }

    /**
     * Generates a list with elements from size to 0 in descending order
     * @param size the size of the list
     * @return the generated list
     */
    public static ArrayList<Integer> generateDescending(int size) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = size-1; i >= 0; i--) {
            arr.add(i);
        }
        return arr;
    }

    /**
     * A helper function that swaps elements at l and r
     *
     * @param arr the array to be swapped
     * @param l index of first item
     * @param r index of second item
     * @param <T>
     */
    private static <T> void swap(ArrayList<T> arr, int l, int r) {
        if (l == r) {
            return;
        }
        T temp = arr.get(l);
        arr.set(l, arr.get(r));
        arr.set(r, temp);
    }

}
