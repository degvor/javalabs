package lab5.Threads;

import lab5.Systems.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Spectator extends Thread {
    private Service service;

    @Override
    public void run() {
        while(service.isQOpen) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            System.out.println("Queue size: " + service.getCurrentQueueLength()
                    + ", fail probability: " + Math.round(service.calculateRejectedPercentage() * 100.0) / 100.0);
        }
    }
}
