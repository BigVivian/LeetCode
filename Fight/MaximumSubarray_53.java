package Fight;

/**
 * 求数组中，连续的子数组的最大和
 * 
 * @author Vivian
 * 
 */
public class MaximumSubarray_53 {
	public int maxSubArray(int[] A) {
		if (A.length <= 0) {
			return 0;
		}

		int sum = A[0];
		int max = sum;

		for (int i = 1; i <= A.length - 1; i++) {

			// 如果累计的和已小于0，则加上A[i]将小于A[i],因此有sum=A[i]
			if (sum <= 0) {
				sum = A[i];
			} else {
				sum += A[i];
			}

			max = sum > max ? sum : max;
		}

		return max;
	}

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarray_53 test = new MaximumSubarray_53();
		int res = test.maxSubArray(A);

		System.out.println(res);
	}
}
