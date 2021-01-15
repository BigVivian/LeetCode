package Fight;

public class MaxIncreasetoKeepCitySkyline_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rMax = new int[row];
        int[] cMax= new int[col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                rMax[i] = Math.max(rMax[i], grid[i][j]);
                cMax[j] = Math.max(cMax[j], grid[i][j]);
            }
        }

        int sum = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                sum += Math.min(rMax[i],cMax[j]) - grid[i][j];
            }
        }

        return sum;
    }
}
