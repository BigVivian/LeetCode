package Fight;

/**
 * for n*n 2D matrix, n=3 for example
 * 
 * 1 2 3<br>
 * 4 5 6<br>
 * 7 8 9<br>
 * 
 * move (1,2)
 * 
 * 
 * @author Vivian
 * 
 */
public class RotateImage_48 {
	public void rotate(int[][] matrix) {
		int n = matrix[0].length;

		int A, B, C, D;
		for (int i = 0; i <= n / 2 - 1; i++) {
			for (int j = i; j <= n - i - 2; j++) {
				int tmp = n - 2 * i - 1;
				A = matrix[i][j];
				B = matrix[j][i + tmp];
				C = matrix[i + tmp][i + tmp - (j - i)];
				D = matrix[i + tmp - (j - i)][i];

				matrix[j][i + tmp] = A;
				matrix[i + tmp][i + tmp - (j - i)] = B;
				matrix[i + tmp - (j - i)][i] = C;
				matrix[i][j] = D;
			}
		}

	}

	public static void main(String[] args) {

	}

}
