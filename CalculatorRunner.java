
/**
 * Runs the calculator program
 * Created by Edie Zhou on 1/17/2019.
 */
import java.util.Scanner;

public class CalculatorRunner {
    /**
     *  Runs the calculator, prompting user for type of calculation to make
     */
    public static void runCalculator() {
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // input string indicating type of operation
        String in;

        // integer of operation
        int op;

        System.out.println();
        System.out.println("Enter 1 to add two matrices");
        System.out.println("Enter 2 to subtract two matrices");
        System.out.println("Enter 3 to multiply two matrices");
        System.out.println("Enter 4 to multiply one matrix by a scalar");
        System.out.println("Enter 5 to perform Gauss-Jordan Elimination on " +
                "one matrix");
        in = input.next();
        while((!in.equals("1"))&&(!in.equals("2"))&&(!in.equals("3"))&&
                (!in.equals("4"))&&(!in.equals("5"))){
            System.out.println("Input must be integer from 1 - 4, please " +
                    "try again");
            in = input.next();
        }

        op = Integer.parseInt(in);
        switch(op){
            case 5:
                oneMatrixOperation(op);
                break;
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
        int numRows1;
        int numColumns1;
        int numRows2 = 0;
        int numColumns2 = 0;

        // flag indicates if matrix is valid
        boolean notValid = true;

        // Arrays to hold matrices
        double[][] matrix1;
        double[][] matrix2;
        double[][] result;

        // Set dimensions of the 2 matrices, create matrices, and set values
        matrixNumber = 1;
        System.out.println();
        System.out.println("Enter the number of rows for the first matrix");
        while(!input.hasNextInt()){
            System.out.println("Input must be a positive, non-zero integer, " +
                    "please try again");
            input.next();
        }
        numRows1 = input.nextInt();

        System.out.println("Enter the number of columns for the first matrix");
        numColumns1 = input.nextInt();
        matrix1 = createMatrix(numRows1, numColumns1);
        matrix1 = setValues(matrix1, matrixNumber);

        while(notValid) {
            matrixNumber = 2;
            System.out.println();
            System.out.println("Enter the number of rows for the second matrix");
            numRows2 = input.nextInt();
            System.out.println("Enter the number of columns for the second matrix");
            numColumns2 = input.nextInt();

            // checks if matrix 2 dimensions are valid depending on operation
            switch(op){
                // multiply
                case 3:
                    if(numColumns1 != numRows2){
                        notValid = true;
                        System.out.println("Matrix dimensions are invalid," +
                                " please try again");
                    }
                    else
                        notValid = false;
                    break;
                // subtract
                case 2:
                    if((numRows1 != numRows2) || (numColumns1 != numColumns2)){
                        notValid = true;
                        System.out.println("Matrix dimensions are invalid," +
                                " please try again");
                    }
                    else
                        notValid = false;
                    break;
                // add
                case 1:
                    if((numRows1 != numRows2) || (numColumns1 != numColumns2)){
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
        matrix2 = createMatrix(numRows2, numColumns2);
        matrix2 = setValues(matrix2, matrixNumber);
        result = createMatrix(numRows1, numColumns2);

        switch(op){
            case 3:
                result = BasicOperations.multiply(matrix1, matrix2);
                break;
            case 2:
                result = BasicOperations.subtract(matrix1, matrix2);
                break;
            case 1:
                result = BasicOperations.add(matrix1, matrix2);
                break;
            default:
                break;
        }

        System.out.println();
        System.out.println("Matrix 1:");
        for (int j = 0; j < numRows1; j++) {
            for (int k = 0; k < numColumns1; k++) {
                System.out.printf("%8.3f", matrix1[j][k]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matrix 2:");
        for (int j = 0; j < numRows2; j++) {
            for (int k = 0; k < numColumns2; k++) {
                System.out.printf("%8.3f", matrix2[j][k]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Result Matrix:");
        for (int j = 0; j < numRows1; j++) {
            for (int k = 0; k < numColumns2; k++) {
                System.out.printf("%8.3f", result[j][k]);
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
        int numRows1;
        int numColumns1;

        // scalar to multiply by
        double scalar = 0;

        // Arrays to hold matrices
        double[][] matrix1;
        double[][] result;

        // Set dimensions of the 1 matrices, creates matrix, and set values
        matrixNumber = 1;
        System.out.println();
        System.out.println("Enter the number of rows for the first matrix");
        numRows1 = input.nextInt();
        System.out.println("Enter the number of columns for the first matrix");
        numColumns1 = input.nextInt();
        matrix1 = createMatrix(numRows1, numColumns1);
        matrix1 = setValues(matrix1, matrixNumber);
        result = createMatrix(numRows1, numColumns1);

        System.out.println();
        System.out.println("Matrix 1:");
        for (int j = 0; j < numRows1; j++) {
            for (int k = 0; k < numColumns1; k++) {
                System.out.print(" " + matrix1[j][k] + " ");
            }
            System.out.println();
        }

        switch(op){
            case 5:
                result = RREF.rref(matrix1);
                break;
            case 4:
                System.out.println();
                System.out.println("Enter a scalar to multiply the matrix by");
                scalar = input.nextDouble();
                result = BasicOperations.scalarMultiply(matrix1, scalar);
                break;
            default:
                break;
        }

        System.out.println();
        System.out.println("Matrix1:");
        for (int j = 0; j < numRows1; j++) {
            for (int k = 0; k < numColumns1; k++) {
                System.out.printf("%8.3f", matrix1[j][k]);
            }
            System.out.println();
        }

        if(op == 4)
            System.out.println("Scalar: " + scalar);

        System.out.println();
        System.out.println("Result Matrix:");
        for (int j = 0; j < numRows1; j++) {
            for (int k = 0; k < numColumns1; k++) {
                System.out.printf("%8.3f", result[j][k]);
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
                    System.out.printf("%8.3f", matrix[j][k]);
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

    /
}
