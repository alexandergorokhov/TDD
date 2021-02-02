package euler;


import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.Arrays;


public class SeveralArrays {

    int[] array1;
    int[] array2;


    @Test
    public void checkSum1_test() {
        array1 = new int[] {10, 20, 30, 40};
        array2 = new int[] {1, 2, 3, 4};
        int x = 42;

        boolean isSumPossible = evaluateTwoArrays(array1,array2,x);

       System.out.println("is sum possible " + isSumPossible);
        Assert.assertTrue(isSumPossible);
    }

    @Test
    public void checkSum2_test() {
        array1 = new int[] {10, 20, 30, 40};
        array2 = new int[] {1, 2, 3, 4};
        int x = 45;

        boolean isSumPossible = evaluateTwoArrays(array1,array2,x);

        System.out.println("is sum possible " + isSumPossible);
        Assert.assertTrue(!isSumPossible);

    }

    @Test
    public void checkSum3_test() {
        array1 = new int[] {10, 20, 30, 40};
        array2 = new int[] {-1, 2, 3, 4};
        int x = 39;

        boolean isSumPossible = evaluateTwoArrays(array1,array2,x);

        System.out.println("is sum possible " + isSumPossible);
        Assert.assertTrue(isSumPossible);

    }

    @Test
    public void checkSum4_test() {
        array1 = new int[] {10, 20, 30, 40};
        array2 = new int[] {-1, 2, 3, 4};
        int x = 39;
        boolean isSumPossible = evaluateTwoArrays(array2,array1,x);
        System.out.println("is sum possible " + isSumPossible);
        Assert.assertTrue(isSumPossible);

    }

    // Complexity (n log(n)) + n * log(n)) = 2 n log(n)
    private boolean evaluateTwoArrays(int[] array1, int[] array2, int x) {
        Arrays.sort(array2);
        for (int i = 0 ;i<array1.length; i++){
            int difference = x - array1[i];
           int searchedIndex =  Arrays.binarySearch(array2,difference);
           if(searchedIndex >=0){
               return true;
           }

        }
        return false;

    }
}
