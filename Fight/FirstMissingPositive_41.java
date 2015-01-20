package Fight;

/**
 * Find the first missing positive<br>
 * swap number i to index (i-1)
 * 
 * @author Vivian
 * 
 */
public class FirstMissingPositive_41 {
	public int firstMissingPositive(int[] A) {
		for (int i = 0; i <= A.length - 1; i++) {
			while (A[i] != i + 1) {
				// swap
				if (A[i] - 1 > A.length - 1 || A[i] <= 0 || A[i] == A[A[i] - 1]) {
					break;
				} else {
					int temp = A[A[i] - 1];
					A[A[i] - 1] = A[i];
					A[i] = temp;
				}
			}
		}

		for (int i = 0; i <= A.length - 1; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		return A.length + 1;
	}

	public static void main(String[] args) {
		int A[] = { 2 };
		FirstMissingPositive_41 test = new FirstMissingPositive_41();
		int res = test.firstMissingPositive(A);
		System.out.println(res);
	}

}
