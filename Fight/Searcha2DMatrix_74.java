package Fight;

/**
 * LeetCode -74 / Search a 2D Matrix
 * 
 * 二维矩阵中，从左到右升序，且每行第一个元素比前一行最后一个元素大，判断是否存在值为target的元素
 * 
 * @author Vivian
 * 
 */
public class Searcha2DMatrix_74 {
	int rowCount;
	int colCount;

	public boolean searchMatrix(int[][] matrix, int target) {

		rowCount = matrix.length;
		colCount = matrix[0].length;

		return search(matrix, 0, rowCount * colCount - 1, target);

	}

	private boolean search(int[][] matrix, int start, int end, int target) {

		if (start > end) {
			return false;
		}

		int middle = (start + end) / 2;
		int row = middle / colCount;
		int col = middle % colCount;

		if (matrix[row][col] == target) {
			return true;
		} else if (matrix[row][col] > target) {
			return search(matrix, start, middle - 1, target);
		} else {
			return search(matrix, middle + 1, end, target);
		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1 } };
		int target = 2;
		Searcha2DMatrix_74 test = new Searcha2DMatrix_74();
		boolean res = test.searchMatrix(matrix, target);

		System.out.println(res);
	}

}
