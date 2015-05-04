package Fight;

/**
 * 如果矩阵中有一个元素A[i][j] == 0,则将i行j列的值都赋值为0
 * <p/>
 * 1.先确定第一行和第一列是否需要清零
 * 即，看看第一行中是否有0，记下来。也同时记下来第一列中有没有0。
 * <p/>
 * 2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0
 * 这里不用担心会将本来第一行或第一列的1改成了0，因为这些值最后注定要成为0的，
 * 比如matrix[i][j]==0，那么matrix[i][0]处在第i行，matrix[0][j]处于第j列，最后都要设置为0的。
 * <p/>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroes_73 {
    public void setZeroes(int[][] matrix) {

        boolean firstRowHasZero = false, firstColHasZero = false;

        int row = matrix.length;
        int col = matrix[0].length;


        for (int i = 0; i <= row - 1; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
            }
        }

        for (int i = 0; i <= col - 1; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
            }
        }

        //记录i行j列是否有0
        for (int i = 1; i <= row - 1; i++) {
            for (int j = 1; j <= col - 1; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 对i列赋值为0
        for (int i = 1; i <= col - 1; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j <= row - 1; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // 对j列赋值为0
        for (int i = 1; i <= row - 1; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j <= col - 1; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第一行和第一列
        if (firstRowHasZero) {
            for (int i = 0; i <= col - 1; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i <= row - 1; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}
        };
        SetMatrixZeroes_73 test = new SetMatrixZeroes_73();
        test.setZeroes(matrix);

        System.out.print("******");
    }
}
