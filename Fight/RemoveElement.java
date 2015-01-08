package Fight;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {

		int length = A.length;

		for (int i = 0; i <= length - 1; i++) {
			if (A[i] == elem) {
				A[i] = A[length - 1];
				length--;
				i--;
			}

		}

		return length;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 2 };
		RemoveElement test = new RemoveElement();
		int res = test.removeElement(A, 1);
		System.out.println(res);
	}

}
