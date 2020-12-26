package Fight;

public class DiagonalTraverse_498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int m = matrix[0].length;
        int n = matrix.length;
        int[] res = new int[m*n];

        int r = 0, c = 0, idx = 0;
        for(int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            if((r + c) % 2 == 0) { // moving up
                if(c == m -1) r++;
                else if(r == 0) c++;
                else {
                    c++;
                    r--;
                }
            } else { // moving down
                if(r == n - 1) c++;
                else if(c == 0) r++;
                else {
                    c--;
                    r++;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        DiagonalTraverse_498 solution = new DiagonalTraverse_498();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        solution.findDiagonalOrder(matrix);
    }
}