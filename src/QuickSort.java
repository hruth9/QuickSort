import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Inspired from https://algs4.cs.princeton.edu/20sorting/ 
 */
public class QuickSort {

    public static List<Integer> sort(List<Integer> nums) {
        sort(nums, 0, (nums.size() - 1));
        return nums;
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(List<Integer>  nums, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(nums, lo, hi);
        sort(nums, lo, j-1);
        sort(nums, j+1, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j. 
    private static int partition(List<Integer> nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = nums.get(lo);
        while (true) {

            // find item on lo to swap
            while (nums.get(++i) < v) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (v < nums.get(--j)) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            int swap = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,swap);
        }

        // put partitioning item v at a[j]
        int swap = nums.get(lo);
        nums.set(lo,nums.get(j));
        nums.set(j,swap);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    
    static List<Integer> generateRandomArray(int n){
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        Random random = new Random();
        
        for (int i = 0; i < n; i++)
        {
            list.add(random.nextInt(1000));
        }
    return list;
    }  

    public static void main(String args[])
    {
        for (int i = 100; i <= 20000000; i=i*5) {
            for (int j = 0; j < 5; j++) {
                List<Integer> nums = generateRandomArray(i);
                long startTime = System.nanoTime();
                QuickSort.sort(nums);
                long endTime = System.nanoTime();
                System.out.println(i+","+((endTime - startTime)/1000000));
            }
        }
    }

}
