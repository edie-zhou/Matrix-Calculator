
/**
 * BasicOperations contains basic matrix math operations
 * Created by Edie Zhou on 1/17/2019.
 */

import java.util.Scanner;

public class BasicOperations {
    /**
     *  Adds two matrices
     *  @param matrix1 2D array of first matrix
     *  @param matrix2 2D array of second matrix
     *
     *  @return 2D array result matrix
     */
    public static double[][] add(double[][] matrix1, double[][] matrix2){
        // number of rows
        int numRows = matrix1.length;

        // number of columns
        int numColumns = matrix1[0].length;

        // result matrix
        double[][] result = new double[numRows][numColumns];

        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                result[j][k] = matrix1[j][k] + matrix2[j][k];
            }
        }
        return result;
    }

    /**
     *  Subtracts two matrices
     *  @param matrix1 2D array of first matrix
     *  @param matrix2 2D array of second matrix
     *
     *  @return 2D array result matrix
     */
    public static double[][] subtract(double[][] matrix1, double[][] matrix2){
        // number of rows
        int numRows = matrix1.length;

        // number of columns
        int numColumns = matrix1[0].length;

        // result matrix
        double[][] result = new double[numRows][numColumns];

        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                result[j][k] = matrix1[j][k] - matrix2[j][k];
            }
        }

        return result;
    }

    /**
     *  Multiplies two matrices
     *
     *  @param matrix1 2D array of first matrix
     *  @param matrix2 2D array of second matrix
     *
     *  @return 2D array result matrix
     */
    public static double[][] multiply(double[][] matrix1, double[][] matrix2){
        // number of rows
        int numRows = matrix1.length;

        // number of columns
        int numColumns = matrix2[0].length;

        // result matrix
        double[][] result = new double[numRows][numColumns];

        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                result[j][k] = matrix1[j][k] * matrix2[k][j];
            }
        }

        return result;
    }

    /**
     *  Multiplies matrix by a scalar
     *
     *  @param matrix1 2D array of matrix to multiply
     *  @param scalar scalar to multiply matrix by
     *
     *  @return 2D array result matrix
     */
    public static double[][] scalarMultiply(double[][] matrix1, double scalar){
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // number of rows
        int numRows = matrix1.length;

        // number of columns
        int numColumns = matrix1[0].length;

        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                matrix1[j][k] *= scalar;
            }
        }
        return matrix1;
    }
}
