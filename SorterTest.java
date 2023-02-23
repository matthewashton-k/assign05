package assign05;

import assign03.SimplePriorityQueue;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class SorterTest {

    @Test
    public void testMergesortPermuted() {
        for (int k = 0; k < 2000; k++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                arr.add(i);
            }

            Collections.shuffle(arr);

            ArrayListSorter.mergesort(arr);


            for (int i = 0; i < k; i++) {
                assertEquals(i, arr.get(i));
            }
        }
    }

    @Test
    public void testMergeSortRandom() {
        Random rng = new Random();
        for (int n = 0; n < 2000; n++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(rng.nextInt());
            }
            ArrayListSorter.mergesort(arr);

            for (int i = 0; i < arr.size()-1; i++) {
                assertTrue(arr.get(i).compareTo(arr.get(i+1))<0);
            }
        }
    }

    @Test
    public void testQuicksort() {
        for (int k = 0; k < 2000; k++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                arr.add(i);
            }

            Collections.shuffle(arr);

            ArrayListSorter.quicksort(arr);

            for (int i = 0; i < k; i++) {
                assertEquals(i, arr.get(i));
            }

        }

    }

    @Test
    public void testInsertionsort() {
        for (int k = 0; k < 2000; k++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                arr.add(i);
            }

            Collections.shuffle(arr);



            ArrayListSorter.insertionsort(arr, 0, arr.size());

            for (int i = 0; i < k; i++) {
                assertEquals(i, arr.get(i));
            }

        }
    }

    @Test
    public void testInsertionWithSubArray() {
        var arr = new ArrayList<Integer>();

        arr.add(9);
        arr.add(8);
        arr.add(7);
        arr.add(6);
        arr.add(5);
        arr.add(4);


        ArrayListSorter.insertionsort(arr,2, 5);
        for (int i : arr) {
            //System.out.println(i);
        }
    }

}
