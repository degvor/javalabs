package lab4.task4;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        var keyWords = new String[]{"computer"};
        var pool = ForkJoinPool.commonPool();
        var task = new DirSearchKWord("src/main/java/lab4/texts", keyWords);

        var filePaths = pool.invoke(task);
        pool.shutdown();

        System.out.println("Keywords " + Arrays.toString(keyWords) + " were found in files: ");
        for (var file : filePaths) {
            System.out.println("- " + file);
        }
    }
}
