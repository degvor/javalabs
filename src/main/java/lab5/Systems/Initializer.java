package lab5.Systems;

import lab5.Threads.Consumer;
import lab5.Threads.Producer;
import lab5.Threads.Spectator;
import lab5.Threads.Statistic;
import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Initializer implements Callable<double[]> {
    private boolean isSpectated;

    public double[] call() {
        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        var service = new Service();

        var statistic = new Statistic(service);

        // add to pool
        executor.execute(new Consumer(service));
        if (isSpectated)
            executor.execute(new Spectator(service));
        executor.execute(new Producer(service));
        executor.execute(statistic);

        executor.shutdown();

        System.out.println("System is started");

        // w8 to finish
        try {
            boolean ok = executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new double[]{service.calculateRejectedPercentage(), statistic.getAverageQueueLength()};
    }
}
