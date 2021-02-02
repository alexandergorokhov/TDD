package euler;


import org.junit.Test;


public class Euler {

    @Test
    public void findSumMultiples() {
        int n = 1000;
        int mul1 = 3;
        int mul2 = 5;
       int aux1 = (int) (3 * (0.5 * 333*(334)));
        int aux2 = (int) (5 * (0.5 * 199*(200)));;
        int aux3 = (int) (15 * (0.5 * 66*(67)));;



       System.out.println("aux1 " + aux1);

        System.out.println("aux2 " + aux2);

        System.out.println("aux3 " + aux3);
        int result = (aux1 + aux2 - aux3);
        System.out.println("final " + result);
    }
}
