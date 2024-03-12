package lab2.test;

import lab2.Tools.MatrixEntity;
import lab2.Tools.RandomMatrixGenerator;

public class Task4Test {
    public static void main(String[] args) {
        RandomMatrixGenerator randomMatrixGenerator = new RandomMatrixGenerator();

        var MATRIX_SIZE = 1500;
        var THREADS_COUNT = 8;

        var startTime = System.currentTimeMillis();
        var endTime = System.currentTimeMillis();


        var matrixEntity = new MatrixEntity(
                randomMatrixGenerator
                        .generateRandomMatrix(MATRIX_SIZE, MATRIX_SIZE)
                        .getMatrix());

        var matrixEntity2 = new MatrixEntity(
                randomMatrixGenerator
                        .generateRandomMatrix(MATRIX_SIZE, MATRIX_SIZE)
                        .getMatrix());

        var parallelCalculator = new lab2.Algorithms.Parallel.ParallelCalculator();
        var foxCalculator = new lab2.Algorithms.Fox.FoxCalculator(matrixEntity, matrixEntity2, THREADS_COUNT);

        // Parallel test
        startTime = System.currentTimeMillis();
        var parRes = new MatrixEntity(parallelCalculator.multiplyMatrix(matrixEntity, matrixEntity2, THREADS_COUNT).getMatrix());
        endTime = System.currentTimeMillis();
        System.out.println("Parallel: " + (endTime - startTime) + " ms " + "with " + THREADS_COUNT + " threads" );

        // Fox test
        startTime = System.currentTimeMillis();
        var foxRes = new MatrixEntity(foxCalculator.multiplyMatrix().getMatrix());
        endTime = System.currentTimeMillis();
        System.out.println("Fox: " + (endTime - startTime) + " ms " + "with " + THREADS_COUNT + " threads" );

        // Check results
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (parRes.get(i, j) != foxRes.get(i, j)) {
                    System.out.println("Error");
                    return;
                }
            }
        }
    }
}
