package Fight;

/**
 * 给定数组，求连续的子数组中，乘积最大的子数组
 * 
 * 同时记录最大值和最小值
 * 
 * similar like Maximum Subarray question<br>
 * difference is the max value could be get from 3 situations<br>
 * 
 * 1.current maxValue * A[i] if A[i]>0 <br>
 * 2.current minValue * A[i] if A[i]<0 <br>
 * 3.A[i] <br>
 * 
 * We need to record current maxValue, current minValue and update them every
 * time get the new product
 * 
 * @author Vivian
 * 
 */
public class MaximumProductSubarray_152 {
	public int maxProduct(int[] nums) {
		if (nums.length <= 0) {
			return 0;
		}
		if (nums.length == 0) {
			return nums[0];
		}

		int res = nums[0];
		int curMin = nums[0];
		int curMax = nums[0];

		// 同时记录最大值和最小值
		for (int i = 1, len = nums.length; i <= len - 1; i++) {
			int temp1 = curMin * nums[i];
			int temp2 = curMax * nums[i];

			curMin = min3(nums[i], temp1, temp2);
			curMax = max3(nums[i], temp1, temp2);

			res = curMax > res ? curMax : res;
		}
		return res;
	}

	private int min3(int a, int b, int c) {
		int res = a;
		res = b < res ? b : res;
		res = c < res ? c : res;

		return res;
	}

	private int max3(int a, int b, int c) {
		int res = a;
		res = b > res ? b : res;
		res = c > res ? c : res;

		return res;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, -2, 4 };
		MaximumProductSubarray_152 test = new MaximumProductSubarray_152();
		int res = test.maxProduct(A);
		System.out.println(res);
	}

}
