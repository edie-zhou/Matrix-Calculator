/**
 * RREF contains advanced matrix math operations
 * Created by Edie Zhou on 1/17/2019.
 */
public class RREF {
    /**
     * Puts a matrix into reduced row echelon form
     *
     * @param matrix input matrix
     *
     * @return 2D result matrix
     */
    public static double[][] rref(double[][] matrix){
        // number of rows and columns in matrix
        int numRows = matrix.length;
        int numColumns = matrix[0].length;

        // result matrix
        double[][] result = new double[numRows][numColumns];

        return result;
    }

    /**
     * Adds 2 rows together row2 = row2 + row1
     *
     * @param matrix matrix before row additon
     * @param rowIndex1 int index of row to be added
     * @param rowIndex2 int index or row that row1 is added to
     *
     * @return matrix after row addition
     */
    private static double[][] rowAdd(double[][] matrix, int rowIndex1,
                                      int rowIndex2){
        // number of rows and columns in matrix
        int numRows = matrix.length;
        int numColumns = matrix[0].length;

        // result matrix
        double[][] result = new double[numRows][numColumns];

        return result;
    }

    /**
     * Adds 2 rows together row2 = row2 + row1
     *
     * @param matrix matrix before row additon
     * @param rowIndex int index of row to be scaled
     * @param scalar double to scale row by
     *
     * @return matrix after row scaling
     */
    private static double[][] rowScale(double[][] matrix, int rowIndex,
                                      double scalar){
        // number of rows and columns in matrix
        int numRows = matrix.length;
        int numColumns = matrix[0].length;

        // result matrix
        double[][] result = new double[numRows][numColumns];

        return result;
    }
}