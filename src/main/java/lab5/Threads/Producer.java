package lab5.Threads;

import lab5.Systems.Service;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Producer extends Thread {
    private final Service service;

    @Override
    public void run() {
        var random = new Random();
        var startTime = System.currentTimeMillis();
        long elapsedTime = 0;

        while (elapsedTime < 10_000) {
            this.service.push(random.nextInt(100));

            try {
                Thread.sleep(random.nextInt(15));
            } catch (InterruptedException ignored) {
            }

            elapsedTime = System.currentTimeMillis() - startTime;
        }

        service.isQOpen = false;
    }
}
