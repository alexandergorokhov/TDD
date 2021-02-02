package euler;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class Array {

    int[] array1;
    int result;

    /*
    * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the number of the new array.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Given an example:
input = [0,0,1,1,1,2,2,3,4,5],

Your function should return the length 6 and array input being modified to 0, 1, 2, 3, 4 and 5 respectively.

It doesn't matter what values are set beyond the returned length.

    * */


    @Test
    public void take0AtLastPosition_test() {
        array1 = new int[] {0,0,1,1,1,2,2,3,4,5};
        int[] arrayResult = new int[] {0,1,2,3,4,5};

        result = eliminateDuplicates(array1);

        Assert.assertEquals(result,Arrays.copyOf(array1,6).length);
        Assert.assertTrue(Arrays.equals(arrayResult,Arrays.copyOf(array1,6)));

    }

    // Complexity O(n)
    private int eliminateDuplicates(int[] array1) {
        int j = 1;
        int count = 1;

        for (int i = 1;i<array1.length;i ++){

            if (array1[i]!=array1[j] && array1[i]!=array1[j-1] ) {
                array1[j] = array1[i];
                j++;
                count ++;
            }
        }
        return count;
    }





}
