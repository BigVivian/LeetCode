package Fight;

/**
 * leetcode - 64
 * https://leetcode.com/problems/minimum-path-sum/
 * dynamic programming
 */
public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(row == 0 && col == 0) grid[row][col] = grid[row][col];
                else if(row == 0) grid[row][col] = grid[row][col] + grid[row][col - 1];
                else if(col == 0) grid[row][col] = grid[row][col] + grid[row-1][col];
                else grid[row][col] = grid[row][col] + Math.min(grid[row][col-1], grid[row-1][col]);
            }
        }

        return grid[m-1][n-1];
    }
}
