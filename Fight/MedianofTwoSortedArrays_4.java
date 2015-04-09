package Fight;

/**
 * 求两个排序数组的中位数 <br>
 * 
 * 可转化为求两个排序数组中的第K大的数，注意边界条件
 * 
 * @author Vivian
 * 
 */
public class MedianofTwoSortedArrays_4 {

	public double findMedianSortedArrays(int A[], int B[]) {

		int total = A.length + B.length;
		double medium = 0;

		if (total % 2 == 1) {
			medium = findKthNum(A, B, 0, A.length - 1, 0, B.length - 1,
					(total + 1) / 2);
		} else {
			medium = (findKthNum(A, B, 0, A.length - 1, 0, B.length - 1,
					total / 2) + findKthNum(A, B, 0, A.length - 1, 0,
					B.length - 1, total / 2 + 1)) / 2;
		}

		return medium;
	}

	// 返回A和B中第K大的数
	private double findKthNum(int[] A, int[] B, int startA, int endA,
			int startB, int endB, int k) {

		int lenA = endA - startA + 1;
		int lenB = endB - startB + 1;

		// 默认 lenA < lenB
		if (lenA > lenB) {
			return findKthNum(B, A, startB, endB, startA, endA, k);
		}

		// A中无元素，返回B中的第K大的数
		if (lenA == 0) {
			return B[startB + k - 1];
		}

		// 返回A[0]和B[0]中的较小值
		if (k == 1) {
			return Math.min(A[startA], B[startB]);
		}

		int pa = Math.min(k / 2, lenA);
		int pb = k - pa;

		// A[0] ~ A[k/2 -1]不可能包含第K大的数
		if (A[startA + pa - 1] < B[startB + pb - 1]) {
			return findKthNum(A, B, startA + pa, endA, startB, endB, k - pa);
		} else if (A[startA + pa - 1] > B[startB + pb - 1]) {
			return findKthNum(A, B, startA, endA, startB + pb, endB, k - pb);
		} else {
			return A[startA + pa - 1];
		}

	}

	public static void main(String[] args) {
		MedianofTwoSortedArrays_4 test = new MedianofTwoSortedArrays_4();
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10 };
		int[] B = { 100 };
		double medium = test.findMedianSortedArrays(A, B);
		System.out.println(medium);
	}

}
