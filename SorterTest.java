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
        for (int n = 0; n < 5000; n++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(rng.nextInt());
            }
            ArrayListSorter.mergesort(arr);

            for (int i = 0; i < arr.size()-1; i++) {
                assertTrue(arr.get(i).compareTo(arr.get(i+1))<=0);
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
    public void testQuickSortRandom() {
        Random rng = new Random();
        for (int n = 0; n < 5000; n++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(rng.nextInt());
            }
            ArrayListSorter.quicksort(arr);

            for (int i = 0; i < arr.size()-1; i++) {
//                System.out.println(arr.get(i)+" "+arr.get(i+1));
                if (arr.get(i).compareTo(arr.get(i+1))>0) {
                    fail(arr.get(i)+" "+arr.get(i+1));
                }
//                assertTrue(arr.get(i).compareTo(arr.get(i+1))<=0);
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
    public void testInsertionSortRandom() {
        Random rng = new Random();
        for (int n = 0; n < 2000; n++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(rng.nextInt());
            }
            ArrayListSorter.insertionsort(arr, 0, arr.size());

            for (int i = 0; i < arr.size()-1; i++) {
//                System.out.println(arr.get(i)+" "+arr.get(i+1));
                if (arr.get(i).compareTo(arr.get(i+1))>0) {
                    fail(arr.get(i)+" "+arr.get(i+1));
                }
//                assertTrue(arr.get(i).compareTo(arr.get(i+1))<=0);
            }
        }
    }

    @Test
    public void testInsertionWithSubArray() {
        var arr = new ArrayList<Integer>();

        arr.add(9); //0
        arr.add(8); //1
        arr.add(7); //2
        arr.add(6); //3
        arr.add(5); //4
        arr.add(4); //5

        ArrayListSorter.insertionsort(arr,2, 5);
        assertEquals(9, arr.get(0));
        assertEquals(8, arr.get(1));
        assertEquals(5, arr.get(2));
        assertEquals(6, arr.get(3));
        assertEquals(7, arr.get(4));
        assertEquals(4, arr.get(5));
    }

    @Test
    public void testPermuted() {

        for (int n = 0; n < 2000; n++) {
            ArrayList<Integer> arr = ArrayListSorter.generatePermuted(n);
            assertEquals(n, arr.size());
            for (int i = 0; i < n; i++) {
                assertTrue(arr.contains(i));
            }
        }
    }

    @Test
    public void testDescending() {
        for (int n = 0; n < 2000; n++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = n-1; i >= 0; i--) {
                arr.add(i);
            }
            assertEquals(arr, ArrayListSorter.generateDescending(n));
        }
    }

    @Test
    public void testAscending() {
        for (int size = 0; size < 2000; size++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                arr.add(i);
            }
            assertEquals(arr, ArrayListSorter.generateAscending(size));
        }

    }
}
