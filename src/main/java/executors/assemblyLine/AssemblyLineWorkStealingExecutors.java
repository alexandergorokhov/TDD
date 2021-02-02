package executors.assemblyLine;

import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

public final class AssemblyLineWorkStealingExecutors {

    private static ExecutorService producerService;
    private static final int MAX_PROD_BULBS = 15_000_000;
    private static final BlockingQueue<String> queue
            = new LinkedBlockingDeque<>();

    private AssemblyLineWorkStealingExecutors() {
        throw new AssertionError("There is a single assembly line!");
    }

    private static final int MAX_PROD_TIME_MS = 5 * 1000;
    private static final int MAX_CONS_TIME_MS = 7 * 1000;
    private static final int TIMEOUT_MS = MAX_CONS_TIME_MS + 1000;
    private static final Random rnd = new Random();
    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;

    private static final int PRODUCERS = 3;
    private static final int CONSUMERS = 2;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static final int PROCESSORS
            = Runtime.getRuntime().availableProcessors();
    private static ExecutorService consumerService
            = Executors.newFixedThreadPool(PROCESSORS);

    private static void simulatingProducers() {
        System.out.println("Simulating the job of the producers overnight ...");
        System.out.println("The producers checked "
                + MAX_PROD_BULBS + " bulbs ...");

        for (int i = 0; i < MAX_PROD_BULBS; i++) {
            queue.offer("bulb-" + rnd.nextInt(1000));
        }
    }

    public static void startAssemblyLine() {

        if (runningProducer || runningConsumer) {
            System.out.println("Assembly line is already running ...");
            return;
        }

        System.out.println("\n\nStarting assembly line ...");
        System.out.println("Remaining bulbs from previous run: \n"
                + queue + "\n\n");

        runningProducer = true;
     /*   producerService = Executors.newFixedThreadPool(PRODUCERS);
        for (int i = 0; i < PRODUCERS; i++) {
            producerService.execute(producer);
        }*/
        simulatingProducers();
        runningConsumer = true;
        for (int i = 0; i < queue.size(); i++) {
            consumerService.execute(consumer);
        }
    }

    public static void stopAssemblyLine() {

        System.out.println("Stopping assembly line ...");

        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (!isProducerDown || !isConsumerDown) {
            System.out.println("Something abnormal happened during ");

            System.exit(0);
        }

        System.out.println("Assembling line was successfully stopped!");
    }

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (runningProducer) {
                try {
                    String bulb = "bulb-" + rnd.nextInt(1000);

                    Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));

                    boolean transfered = queue.offer(bulb);

                    if (transfered) {
                        System.out.println("Checked: " + bulb);
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println("Exception: " + ex);
                    break;
                }
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (runningConsumer) {
                try {
                    String bulb = queue.poll();

                    if (bulb != null) {
                        System.out.println("Packed: " + bulb);
                    }
                } catch (RuntimeException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println( "Exception: " + ex);
                    break;
                }
            }
        }
    }



    private static boolean shutdownProducer() {
        runningProducer = false;
        return shutdownExecutor(producerService);
    }

    private static boolean shutdownConsumer() {
        runningConsumer = false;
        return shutdownExecutor(consumerService);
    }

    private static boolean shutdownExecutor(ExecutorService executor) {

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT_MS * 2,
                    TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
                return executor.awaitTermination(TIMEOUT_MS * 2,
                        TimeUnit.MILLISECONDS);
            }

            return true;
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Exception: " + ex);
        }

        return false;
    }
}
