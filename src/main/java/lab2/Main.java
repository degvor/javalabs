package lab2;

import lab2.Algorithms.Fox.FoxCalculator;
import lab2.Algorithms.Sequential.SequentialCalculator;
import lab2.Tools.MatrixEntity;
import lab2.Tools.RandomMatrixGenerator;

public class Main {
    public static void main(String[] args) {
        RandomMatrixGenerator randomMatrixGenerator = new RandomMatrixGenerator();

        var SIZE = 8;
        var matrixEntity = new MatrixEntity(new int[][]{
                {1, 5},
                {2, 3},
                {1, 7}
        });

        var matrixEntity2 = new MatrixEntity(new int[][]{
                {1, 2, 3, 7},
                {5, 2, 8, 1}
        });

        var matrixEntity3 = new MatrixEntity(
                randomMatrixGenerator
                        .generateRandomMatrix(SIZE, SIZE)
                        .getMatrix());

        var matrixEntity4 = new MatrixEntity(
                randomMatrixGenerator
                        .generateRandomMatrix(SIZE, SIZE)
                        .getMatrix());

        System.out.println("Matrix 3:");
        matrixEntity3.print2D();
        System.out.println("####");

        System.out.println("Matrix 4:");
        matrixEntity4.print2D();
        System.out.println("####");

        var sequentialCalculator = new SequentialCalculator();
        var res = new MatrixEntity(sequentialCalculator.multiplyMatrix(matrixEntity3, matrixEntity4).getMatrix());
        System.out.println("sequential result:");
        res.print2D();

        var parallelCalculator = new lab2.Algorithms.Parallel.ParallelCalculator();
        System.out.println("parallel result:");
        var res2 = new MatrixEntity(parallelCalculator.multiplyMatrix(matrixEntity3, matrixEntity4, 4).getMatrix());
        res2.print2D();

        var foxCalculator = new FoxCalculator(matrixEntity3, matrixEntity4, 4);
        System.out.println("fox result:");
        var res3 = new MatrixEntity(foxCalculator.multiplyMatrix().getMatrix());
        res3.print2D();
    }

}
