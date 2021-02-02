package multiThread;

import executors.SimpleExecutor;
import org.junit.Test;

public class Executors {


    @Test
    public void simpleExecutor() {
        SimpleExecutor se = new SimpleExecutor();
        se.execute(() -> System.out.println("Simple task executed via Executor interface"));
    }
}
