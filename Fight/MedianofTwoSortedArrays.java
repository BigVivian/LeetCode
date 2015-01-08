package Fight;

public class MedianofTwoSortedArrays {

	// TODO
	public double findMedianSortedArrays(int A[], int B[]) {

		int total = A.length + B.length;
		double medium = 0;

		if (total % 2 == 0) {
			medium = findKthNum(A, B, total / 2);
		} else {
			medium = (findKthNum(A, B, (total - 1) / 2) + findKthNum(A, B,
					(total + 1) / 2)) / 2;
		}

		return medium;
	}

	private double findKthNum(int[] A, int[] B, int k) {
		return 0;
	}

	public static void main(String[] args) {
		MedianofTwoSortedArrays test = new MedianofTwoSortedArrays();
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] B = { 100 };
		double medium = test.findMedianSortedArrays(A, B);
		System.out.println(medium);
	}

}
