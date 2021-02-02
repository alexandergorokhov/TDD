package euler;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;


public class Array0Last {

    int[] array1;
    int[] result;


    @Test
    public void take0AtLastPosition_test() {
        array1 = new int[] {1,0,3,4,0,0,1,2};
        result = new int[] {1,3,4,1,2,0,0,0};

        result = take0ToLastPositions(array1);
        System.out.println("Result array " + result);
        Assert.assertTrue(Arrays.equals(result,take0ToLastPositions(array1)));
    }

    @Test
    public void take0AtLastPosition2_test() {
        array1 = new int[] {1,0,3,4,0,0,1,2};
        result = new int[] {1,3,4,1,2,0,0,0};

        result = take0ToLastPositions(array1);
        System.out.println("Result array " + result);
        Assert.assertTrue(Arrays.equals(result,take0ToLastPositions(array1)));
    }

    @Test
    public void take0AtLastPosition3_test() {
        array1 = new int[] {-1,0,24,0,4,0,0,1,2};
        result = new int[] {-1,24,4,1,2,0,0,0,0};

        result = take0ToLastPositions(array1);
        System.out.println("Result array " + result);
        Assert.assertTrue(Arrays.equals(result,take0ToLastPositions(array1)));
    }


    
    // Complexity O(n)
    private int[] take0ToLastPositions(int[] array1) {
        int[] aux = new int[array1.length];
        int j = 0;
        for (int i = 0;i<array1.length;i ++){
            int entry = array1[i];
            if(entry == 0){
                continue;
            }else {
                aux[j] = array1[i];
                j++;
            }
        }
        return aux;
    }





}
