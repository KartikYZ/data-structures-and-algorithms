package dynamic_programming;

public class Matrices {
    
    /**
     * Area of largest square of 1's in a matrix.
     * @param matrix 2d array of integers
     * @return area of largest square of 1's.
     */
    public static int largestSquareSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = matrix;

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                if(matrix[i][j] == 1){
                  dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max * max;
    }
}
