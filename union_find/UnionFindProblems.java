package union_find;

import java.util.HashMap;
import java.util.HashSet;

public class UnionFindProblems {
    public int largestIsland(int[][] grid) { 
        int n = grid.length;
        int[][] uf = new int[n][n];
        // label:size
        HashMap<Integer, Integer> map = new HashMap<>();
        // label of zero means size of island is zero
        map.put(0, 0);
        int current_label = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1 && uf[i][j] == 0) {
                    map.put(++current_label, dfs(i, j, grid, uf, current_label));
                }
            }
        }
        
        int maxSize = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    maxSize = Math.max(maxSize, newSize(i, j, uf, map));
                }
            }
        }
        
        for (int label: map.keySet()) {
            maxSize = Math.max(maxSize, map.get(label));
        }
        
        return maxSize;
    }
    
    private static int dfs(int i, int j, int[][] grid, int[][] uf, int label) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length) {
            return 0;
        } else if (uf[i][j] != 0 || grid[i][j] == 0) {
            return 0;
        }
        uf[i][j] = label;
        return 1 + dfs(i - 1, j, grid, uf, label)
         + dfs(i, j - 1, grid, uf, label)
         + dfs(i + 1, j, grid, uf, label)
         + dfs(i, j + 1, grid, uf, label);
    }
    
    private int newSize(int i, int j, int[][] uf, HashMap<Integer, Integer> map) {
        HashSet<Integer> labels = new HashSet<>();
        labels.add(cellSize(i - 1, j, uf));
        labels.add(cellSize(i, j - 1, uf));
        labels.add(cellSize(i + 1, j, uf));
        labels.add(cellSize(i, j + 1, uf));
        
        int size = 1;
        for (int label: labels) {
            size += map.get(label);
        }
        return size;
    }
    
    // returns label NOT size, misnomer
    private int cellSize(int i, int j, int[][] uf) {
       if (i < 0 || j < 0 || i >= uf.length || j >= uf.length) {
           return 0;
       }
       return uf[i][j];
    }
}