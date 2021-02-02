package multiThread;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;


public class PriorityQueue {

    int[] array1;
    int[] array2;


    @Test
    public  void init() {
        Integer[] initQueue = new Integer[]{10, 20, 30, 40};
        PriorityBlockingQueue<Integer> queue =
                new PriorityBlockingQueue<Integer>(10, Comparator.naturalOrder());

        queue.addAll(Arrays.asList(initQueue));
        Integer val = queue.poll();
        while (val != null) {
            System.out.println("Queue number: " + val);
            val=queue.poll();
        }
    }

}
