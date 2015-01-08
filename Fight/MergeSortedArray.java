package Fight;

/**
 * 合并两个排好序的数组，从后往前复制。<br>
 * 从尾到头比较A1和A2中的数字，并将较大的数字复制到A1的合适位置。
 * 
 * @author Vivian
 * 
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {

		int maxIndex = m + n - 1;
		int currentA = m - 1;
		int currentB = n - 1;

		while (currentB >= 0) {
			if (currentA < 0) {
				// finish copy A[]
				A[maxIndex] = B[currentB];
				currentB--;
			} else {
				if (A[currentA] > B[currentB]) {
					A[maxIndex] = A[currentA];
					currentA--;
				} else {
					A[maxIndex] = B[currentB];
					currentB--;
				}
			}

			maxIndex--;
		}
	}

	public static void main(String[] args) {
		MergeSortedArray test = new MergeSortedArray();
		int[] A = new int[8];
		for (int i = 0; i <= 4; i++) {
			A[i] = i + 1;
		}
		int m = 5;
		int[] B = { -2, -1, 6 };
		int n = 3;
		test.merge(A, m, B, n);

		for (int num : A) {
			System.out.print(num + ",");
		}

	}
}
