package lab6;

public class MatrixTools {
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrix(double[][] arr, double value) {

        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = arr[i][j] = value;
            }
        }
    }

    public static double[] convert2DTo1D(double[][] arr2D) {
        int rows = arr2D.length;
        int cols = arr2D[0].length;
        double[] arr1D = new double[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr1D[index++] = arr2D[i][j];
            }
        }

        return arr1D;
    }

    public static double[][] convert1DTo2D(double[] arr1D, int rows, int cols) {
        double[][] arr2D = new double[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr2D[i][j] = arr1D[index++];
            }
        }

        return arr2D;
    }

    public static void fillMatrixWithOffset(double[][] matrix, double[] array, int offsetByRows) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int index = 0;

        for (int i = offsetByRows; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(index == array.length)
                    return;
                matrix[i][j] = array[index];
                index++;
            }
        }
    }
}