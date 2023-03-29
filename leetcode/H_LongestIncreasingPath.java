package leetcode;

/*
 * 329. Longest Increasing Path in a Matrix
 * Hard
 */

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] mem = new int[m][n];
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(-1, i, j, matrix, mem);
                ans = Math.max(ans, mem[i][j]);
            }
        }
        
        return ans;
    }
    
    private int dfs(int prev, int i, int j, int[][] mat, int[][] mem) {
        int m = mat.length;
        int n = mat[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) { return 0; }
        if (prev >= mat[i][j]) { return 0; }
        if (mem[i][j] > 0) { return mem[i][j]; }
        int v = mat[i][j];
        
        mem[i][j] = 1 + Math.max(Math.max(dfs(v, i+1, j, mat, mem), dfs(v, i-1, j, mat, mem)), Math.max(dfs(v, i, j+1, mat, mem), dfs(v, i, j-1, mat, mem)));
        return mem[i][j];
    }
}