package lab5.Threads;

import lab5.Systems.Service;
import lombok.AllArgsConstructor;

import java.util.Random;
@AllArgsConstructor
public class Consumer extends Thread {
    private final Service service;

    @Override
    public void run() {
        var random = new Random();

        while(service.isQOpen) {
            service.pop();
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException ignored) {}

            service.incrementApprovedCount();
        }
    }

}
