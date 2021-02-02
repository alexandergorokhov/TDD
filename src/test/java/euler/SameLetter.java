package euler;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


public class SameLetter {

    String[] array1;

    @Test
    public void checkSum1_test() {
        array1 = new String[] {"abc", "cba", "aa", "bb"};
        int count = 0;
        count = countWords(array1);
        System.out.println("Letter count " + count);
        Assert.assertEquals(3,count);
    }

    @Test
    public void checkSum2_test() {
        array1 = new String[] {"abc", "cba", "aa", "cbb"};
        int count = 0;
        count = countWords(array1);
        System.out.println("Letter count " + count);
        Assert.assertEquals(3,count);
    }

    @Test
    public void checkSum3_test() {
        array1 = new String[] {"abc", "cba", "bca"};
        int count = 0;
        count = countWords2(array1);
        System.out.println("Letter count " + count);
        Assert.assertEquals(4,count);
    }
    
    // Complexity O(n) * n log (n) =
    private int countWords(String[] array1) {
        StringBuilder[] aux = new StringBuilder[array1.length+1];
        HashSet<String> set = new HashSet();
        for (int i = 0;i<array1.length;i ++){
            char[] entry = array1[i].toCharArray();
            Arrays.sort(entry);
            aux[i] = new StringBuilder(String.valueOf(entry));
            set.add(aux[i].toString());
        }

        return set.size();
    }

    // Complexity O(n) * n log (n) =
    private int countWords2(String[] array1) {
        HashSet<String> set = new HashSet();
        for (int i = 0;i<array1.length;i ++){
           if(!set.contains(String.valueOf(new StringBuilder(array1[i]).reverse()))){
               set.add(array1[i]);
           }
        }
        return set.size();
    }


}
