package Fight;

/**
 * LeetCode - 36 / Valid Sudoku / 判断一个九宫格是否valid
 * <p/>
 * board[i][j] 属于第(i-i%3+j/3)个block
 * <p/>
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 */
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    int cur = board[i][j] - '1';

                    if (row[i][cur] || column[cur][j] || block[i - i % 3 + j / 3][cur]) {
                        return false;
                    }
                    row[i][cur] = true;
                    column[cur][j] = true;
                    block[i - i % 3 + j / 3][cur] = true;
                }
            }
        }

        return true;
    }
}
