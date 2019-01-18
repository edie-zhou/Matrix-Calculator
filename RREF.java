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
        int lead = 0;
        int i;

        // number of rows and columns in matrix
        int numRows = matrix.length;
        int numColumns = matrix[0].length;

        for(int k = 0; k < numRows; k++){
            if(numColumns <= lead){
                break;
            }
            i = k;
            while(matrix[i][lead] == 0){
                i++;
                if(numRows == i){
                    i = k;
                    lead++;
                    if(numColumns == lead){
                        break;
                    }
                }

            }
            matrix = rowSwap(matrix, i, k);
            if(matrix[k][lead] != 0){
                matrix = rowScale(matrix, k, (1/matrix[k][lead]));
            }
            for(i = 0; i < numRows; i++){
                if(i != k){
                    matrix = rowAddScale(matrix, k, i,((-1) * matrix[i][lead]));
                }
            }
            lead++;
        }

        return matrix;
    }

    /**
     * Swap positions of 2 rows
     *
     * @param matrix matrix before row additon
     * @param rowIndex1 int index of row to swap
     * @param rowIndex2 int index of row to swap
     *
     * @return matrix after row swap
     */
    private static double[][] rowSwap(double[][] matrix, int rowIndex1,
                                     int rowIndex2){
        // number of columns in matrix
        int numColumns = matrix[0].length;

        // holds number to be swapped
        double hold;

        for(int k = 0; k < numColumns; k++){
            hold = matrix[rowIndex2][k];
            matrix[rowIndex2][k] = matrix[rowIndex1][k];
            matrix[rowIndex1][k] = hold;
        }

        return matrix;
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
        // number of columns in matrix
        int numColumns = matrix[0].length;

        for(int k = 0; k < numColumns; k++){
            matrix[rowIndex2][k] += matrix[rowIndex1][k];
        }

        return matrix;
    }

    /**
     * Multiplies a row by a scalar
     *
     * @param matrix matrix before row additon
     * @param rowIndex int index of row to be scaled
     * @param scalar double to scale row by
     *
     * @return matrix after row scaling
     */
    private static double[][] rowScale(double[][] matrix, int rowIndex,
                                      double scalar){
        // number of columns in matrix
        int numColumns = matrix[0].length;

        for(int k = 0; k < numColumns; k++){
            matrix[rowIndex][k] *= scalar;
        }

        return matrix;
    }

    /**
     * Adds a row by the scalar of another row
     * row2 = row2 + (row1 * scalar)
     * @param matrix matrix before row additon
     * @param rowIndex1 int index of row to be added
     * @param rowIndex2 int index or row that row1 is added to
     * @param scalar double to scale row by
     *
     * @return matrix after row addition
     */
    private static double[][] rowAddScale(double[][] matrix, int rowIndex1,
                                     int rowIndex2, double scalar){
        // number of columns in matrix
        int numColumns = matrix[0].length;

        for(int k = 0; k < numColumns; k++){
            matrix[rowIndex2][k] += (matrix[rowIndex1][k] * scalar);
        }

        return matrix;
    }

}

