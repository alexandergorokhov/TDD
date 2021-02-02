package executors;

public class SimpleThreadPoolExecutor implements Runnable {
    private final int taskId;

    public SimpleThreadPoolExecutor(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing task " + taskId
                + " via " + Thread.currentThread().getName());
    }


    /**
     * Gets taskId.
     *
     * @return Value of taskId.
     */
    public int getTaskId() {
        return taskId;
    }
}
