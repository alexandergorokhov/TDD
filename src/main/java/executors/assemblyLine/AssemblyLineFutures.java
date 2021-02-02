package executors.assemblyLine;

import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.*;

public final class AssemblyLineFutures {

    private static ExecutorService producerService;
    private static ExecutorService consumerService;
    private static final TransferQueue<String> queue
            = new LinkedTransferQueue<>();

    private AssemblyLineFutures() {
        throw new AssertionError("There is a single assembly line!");
    }

    private static final int MAX_PROD_TIME_MS = 5 * 1000;
    private static final int MAX_CONS_TIME_MS = 7 * 1000;
    private static final int TIMEOUT_MS = MAX_CONS_TIME_MS + 1000;
    private static final Random rnd = new Random();
    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;

    public static void startAssemblyLine() throws InterruptedException, ExecutionException, TimeoutException {

        if (runningProducer || runningConsumer) {
            System.out.println("Assembly line is already running ...");
            return;
        }

        System.out.println("\n\nStarting assembly line ...");
        System.out.println("Remaining bulbs from previous run: \n"
                + queue + "\n\n");
        String bulb = "bulb-" + rnd.nextInt(1000);

        Producer producer = new Producer(bulb);

        runningProducer = true;
        consumerService = Executors.newSingleThreadExecutor();

        runningConsumer = true;
        producerService = Executors.newSingleThreadExecutor();

        new Thread(() -> {
            try {
                automaticSystem();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }).start();


    }

    private static void automaticSystem() throws InterruptedException, ExecutionException, TimeoutException {

        while (runningProducer && runningConsumer) {
            String bulb = "bulb-" + rnd.nextInt(1000);

            Producer producer = new Producer(bulb);
            Future<String> bulbFuture = producerService.submit(producer);

            String checkedBulb = bulbFuture.get(
                    MAX_PROD_TIME_MS + 1000, TimeUnit.MILLISECONDS);

            Consumer consumer = new Consumer(checkedBulb);
            if (runningConsumer) {
                consumerService.execute(consumer);
            }
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

    private static class Producer implements Callable {
        private final String bulb;

        private Producer(String bulb) {
            this.bulb = bulb;
        }

        @Override
        public String call() throws InterruptedException {
            if (runningProducer) {
                Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));

                if (rnd.nextInt(100) < 50) {
                    throw new RuntimeException("Defect: " + bulb);
                } else {
                    System.out.println("Checked: " + bulb);
                }

                return bulb;
            }

            return "";
        }
    }

    private static class Consumer implements Runnable {

        private final String bulb;

        private Consumer(String bulb) {
            this.bulb = bulb;
        }

        @Override
        public void run() {
            if (runningConsumer) {
                try {
                    Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                    System.out.println("Packed: " + bulb);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println("Exception: " + ex);
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

