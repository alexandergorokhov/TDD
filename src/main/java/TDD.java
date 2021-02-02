import executors.ServerInstance;
import executors.SimpleExecutor;
import executors.SimpleThreadPoolExecutor;
import executors.assemblyLine.*;
import functional.Filters;
import functional.Melon;


import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TDD {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {


        // THREAD TESTING
/*
        SimpleExecutor se = new SimpleExecutor();
        se.execute(() -> System.out.println("Simple task executed via Executor interface"));


        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        final AtomicInteger counter = new AtomicInteger();

        ThreadFactory threadFactory = (Runnable r) -> {
            System.out.println("Creating a new Cool-Thread-"
                    + counter.incrementAndGet());

            return new Thread(r, "Cool-Thread-" + counter.get());
        };

        RejectedExecutionHandler rejectedExecutionHandler = (Runnable r, ThreadPoolExecutor executor) -> {
            if (r instanceof SimpleThreadPoolExecutor) {
                SimpleThreadPoolExecutor task = (SimpleThreadPoolExecutor) r;
                System.out.println("Rejecting task " + task.getTaskId());
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 20, 1, TimeUnit.SECONDS, queue, threadFactory,
                rejectedExecutionHandler);

        for (int i = 0; i < 50; i++) {
         //   executor.execute(new SimpleThreadPoolExecutor(i));
        }
        executor.shutdown();
        executor.awaitTermination(
                Integer.MAX_VALUE, TimeUnit.MILLISECONDS);

        ExecutorService executor2 = Executors.newFixedThreadPool(2,threadFactory);
        for (int i = 0; i < 50; i++) {
            executor2.execute(new SimpleThreadPoolExecutor(i));
        }*/
/*
        AssemblyLineProducerFasterThenConsumer.startAssemblyLine();
                Thread.sleep(10 * 1000);
        AssemblyLineProducerFasterThenConsumer.stopAssemblyLine();
*/
      /*  AssemblyLineFutures.startAssemblyLine();
        Thread.sleep(10 * 1000);
        AssemblyLineFutures.stopAssemblyLine();*/
       /* Thread server = new Thread(new ServerInstance());
        server.start();
*/
     /*   System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Thread server = new Thread(new ServerInstance());
        server.start();*/
        List<Melon> l = List.of(new Melon(20), new Melon(30));
        Filters.filterMelons(l, (Melon la) -> la.getSize() > 0
        );

        System.out.println(l);
    }

    // THREAD TESTING
}

