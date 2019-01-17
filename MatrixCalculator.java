/**
 * The Matrix Calculator class is a matrix calculator capable of taking input
 * from the user and performing matrix operations with the input data.
 * Created by Edie Zhou on 1/16/2019.
 */

import java.util.Scanner;

public class MatrixCalculator {
    public static void main(String[] args){
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // Program run status
        boolean status = true;

        // User input choice for calculator operation
        int choice;

        while(status){
            System.out.println();
            System.out.println("This is a matrix calculator");
            System.out.println("Enter 2 to run calculator");
            System.out.println("Enter 1 to exit calculator");
            choice = input.nextInt();
            switch(choice) {
                case 2:
                    runCalculator();
                    break;
                case 1:
                    status = false;
                    break;
                default:
                    status = false;
                    break;
            }
        }
        System.out.println("User has exited the calculator");
    }

    /**
     *  Runs the calculator, prompting user for type of calculation to make
     */
    private static void runCalculator() {
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // int indicating type of operation
        int op;

        System.out.println();
        System.out.println("Enter 1 to add two matrices");
        System.out.println("Enter 2 to subtract two matrices");
        System.out.println("Enter 3 to multiply two matrices");
        System.out.println("Enter 4 to multiply one matrix by a scalar");
        op = input.nextInt();

        switch(op){
            case 4:
                oneMatrixOperation(op);
                break;
            case 3:
                twoMatrixOperation(op);
                break;
            case 2:
                twoMatrixOperation(op);
                break;
            case 1:
                twoMatrixOperation(op);
                break;
            default:
                break;
        }
    }

    /**
     *  Prompts user for size of two matrices and initializes the matrices
     *  and performs operation
     *
     *  @param op int indicating type of operation
     */
    private static void twoMatrixOperation(int op){
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // number of matrix
        int matrixNumber;

        // Rows and columns of 2 matrices
        int rows1;
        int columns1;
        int rows2 = 0;
        int columns2 = 0;

        // flag indicates if matrix is valid
        boolean notValid = true;

        // Arrays to hold matrices
        double[][] matrix1;
        double[][] matrix2;

        // Set dimensions of the 2 matrices, create matrices, and set values
        matrixNumber = 1;
        System.out.println();
        System.out.println("Enter the number of rows for the first matrix");
        rows1 = input.nextInt();
        System.out.println("Enter the number of columns for the first matrix");
        columns1 = input.nextInt();
        matrix1 = createMatrix(rows1, columns1);
        matrix1 = setValues(matrix1, matrixNumber);

        while(notValid) {
            matrixNumber = 2;
            System.out.println();
            System.out.println("Enter the number of rows for the second matrix");
            rows2 = input.nextInt();
            System.out.println("Enter the number of columns for the second matrix");
            columns2 = input.nextInt();

            // checks if matrix 2 dimensions are valid depending on operation
            switch(op){
                // multiply
                case 3:
                    if((rows1 != columns2) || (columns1 != rows2)){
                        notValid = true;
                        System.out.println("Matrix dimensions are invalid," +
                                " please try again");
                    }
                    else
                        notValid = false;
                    break;
                // subtract
                case 2:
                    if((rows1 != rows2) || (columns1 != columns2)){
                        notValid = true;
                        System.out.println("Matrix dimensions are invalid," +
                                " please try again");
                    }
                    else
                        notValid = false;
                    break;
                // add
                case 1:
                    if((rows1 != rows2) || (columns1 != columns2)){
                        notValid = true;
                        System.out.println("Matrix dimensions are invalid," +
                                " please try again");
                    }
                    else
                        notValid = false;
                    break;
                default:
                    break;
            }

        }
        matrix2 = createMatrix(rows2, columns2);
        matrix2 = setValues(matrix2, matrixNumber);

        switch(op){
            case 3:
                multiply(matrix1, matrix2);
                break;
            case 2:
                subtract(matrix1, matrix2);
                break;
            case 1:
                add(matrix1, matrix2);
                break;
            default:
                break;
        }
    }

    /**
     *  Adds two matrices
     *  @param matrix1 2D array of first matrix
     *  @param matrix2 2D array of second matrix
     */
    private static void add(double[][] matrix1, double[][] matrix2){
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

        System.out.println();
        System.out.println("Matrix 1:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + matrix1[j][k] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matrix 2:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + matrix2[j][k] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Result Matrix:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + result[j][k] + " ");
            }
            System.out.println();
        }
    }

    /**
     *  Subtracts two matrices
     *  @param matrix1 2D array of first matrix
     *  @param matrix2 2D array of second matrix
     */
    private static void subtract(double[][] matrix1, double[][] matrix2){
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

        System.out.println();
        System.out.println("Matrix 1:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + matrix1[j][k] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matrix 2:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + matrix2[j][k] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Result Matrix:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + result[j][k] + " ");
            }
            System.out.println();
        }
    }

    /**
     *  Multiplies two matrices
     *  @param matrix1 2D array of first matrix
     *  @param matrix2 2D array of second matrix
     */
    private static void multiply(double[][] matrix1, double[][] matrix2){
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

        System.out.println();
        System.out.println("Matrix 1:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + matrix1[j][k] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matrix 2:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + matrix2[j][k] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Result Matrix:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + result[j][k] + " ");
            }
            System.out.println();
        }
    }

    /**
     *  Prompts user for size of one matrix and initializes the matrix
     *  and performs operation
     *
     *  @param op int indicating type of operation
     */
    private static void oneMatrixOperation(int op){
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // number of matrix
        int matrixNumber;

        // Rows and columns of 1 matrices
        int rows1;
        int columns1;

        // Arrays to hold matrices
        double[][] matrix1;

        // Set dimensions of the 1 matrices, creates matrix, and set values
        matrixNumber = 1;
        System.out.println();
        System.out.println("Enter the number of rows for the first matrix");
        rows1 = input.nextInt();
        System.out.println("Enter the number of columns for the first matrix");
        columns1 = input.nextInt();
        matrix1 = createMatrix(rows1, columns1);
        matrix1 = setValues(matrix1, matrixNumber);

        System.out.println();
        System.out.println("Matrix 1:");
        for (int j = 0; j < rows1; j++) {
            for (int k = 0; k < columns1; k++) {
                System.out.print(" " + matrix1[j][k] + " ");
            }
            System.out.println();
        }

        switch(op){
            case 4:
                scalarMultiply(matrix1);
                break;
            default:
                break;
        }
    }

    /**
     *  Multiplies matrix by a scalar
     *
     *  @param matrix1 2D array of matrix to multiply
     */
    private static void scalarMultiply(double[][] matrix1){
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // number of rows
        int numRows = matrix1.length;

        // number of columns
        int numColumns = matrix1[0].length;

        // result matrix
        double[][] result = new double[numRows][numColumns];

        // scalar to multiply matrix by
        double scalar;

        System.out.println();
        System.out.println("Enter a scalar to multiply the matrix by");
        scalar = input.nextDouble();

        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                matrix1[j][k] *= scalar;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matrix1:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + matrix1[j][k] + " ");
            }
            System.out.println();
        }

        System.out.println("Scalar: " + scalar);

        System.out.println();
        System.out.println("Result Matrix:");
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numColumns; k++) {
                System.out.print(" " + result[j][k] + " ");
            }
            System.out.println();
        }


    }

    /**
     * The CreateMatrix method creates a 2D array of doubles to hold a matrix
     * of user-specified dimensions
     *
     * @param numRows int number of rows
     * @param numColumns int number of columns
     *
     * @return 2D array of doubles
     */
    private static double[][] createMatrix(int numRows, int numColumns){
        double[][] matrix = new double[numRows][numColumns];
        return matrix;
    }

    /**
     * Sets the values in a 2D array, and asks the user to verify matrix input
     *
     * @param matrix 2D double array of matrix
     * @param matrixNumber int number of matrix receiving input
     */
    private static double[][] setValues(double[][] matrix, int matrixNumber) {
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // status of input process
        boolean status = true;

        // data input by user
        double userData;

        // flag set by user to indicate if input matrix data was correct
        int correctData;

        // number of rows in matrix
        int numRows = matrix.length;

        // number of columns in matrix
        int numColumns = matrix[0].length;

        while (status){
            System.out.println();
            for(int j = 0; j < numRows; j++) {
                for (int k = 0; k < numColumns; k++) {
                    System.out.println("Please input value for matrix "
                            + matrixNumber + " at position " + (j + 1) + ","
                            + (k + 1));
                    userData = input.nextDouble();
                    matrix[j][k] = userData;
                }
            }

            System.out.println();
            for(int j = 0; j < numRows; j++) {
                for (int k = 0; k < numColumns; k++) {
                    System.out.print(" " + matrix[j][k] + " ");
                }
                System.out.println();
            }

            System.out.println("Is matrix " + matrixNumber + " correct?");
            System.out.println("Enter 1 to continue to calculator, Enter 0 to" +
                    " re-enter matrix values");
            correctData = input.nextInt();
            switch(correctData){
                case 1:
                    status = false;
                    break;
                case 0:
                    status = true;
                    break;
                default:
                    status = true;
                    break;
            }
        }
        return matrix;
    }

}
