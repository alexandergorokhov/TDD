package executors;

import java.util.concurrent.Executor;

public class SimpleExecutor implements Executor {

    @Override
    public void execute(Runnable runnable) {
        (new Thread()).start();
    }
}


