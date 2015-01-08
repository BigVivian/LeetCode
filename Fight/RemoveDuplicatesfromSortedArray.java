package Fight;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int current = A[0];
		int length = A.length;

		int start = 1;

		for (int i = 1; i <= A.length - 1; i++) {
			if (current == A[i]) {
				length--;
			} else {
				A[start] = A[i];
				start++;
				current = A[i];
			}
		}

		return length;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 1, 1, 2, 2 };
		RemoveDuplicatesfromSortedArray test = new RemoveDuplicatesfromSortedArray();
		int res = test.removeDuplicates(A);
		System.out.println(res);
	}
}
