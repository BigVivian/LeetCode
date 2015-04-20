package Fight;

/**
 * 给定一组非负的数，求出降雨后可容纳的雨水的量
 * 
 * 扫描数组两遍，以确定元素i左右两侧的最大值<br>
 * 
 * 对于i可容纳的雨水量：<br>
 * Math.min(leftMax[i], rightMax[i]) - height[i];
 * 
 * @author Vivian
 * 
 */
public class TrappingRainWater_42 {
	public int trap(int[] height) {

		int len = height.length;
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];

		// 左侧的最大值
		int curMax = 0;
		for (int i = 0; i <= len - 1; i++) {
			leftMax[i] = curMax;
			curMax = height[i] > curMax ? height[i] : curMax;
		}

		// 右侧的最大值
		curMax = 0;
		for (int i = len - 1; i >= 0; i--) {
			rightMax[i] = curMax;
			curMax = height[i] > curMax ? height[i] : curMax;
		}

		// 可容纳的雨水量
		int res = 0;
		for (int i = 0; i <= len - 1; i++) {
			int tmp = Math.min(leftMax[i], rightMax[i]) - height[i];
			if (tmp > 0) {
				res += tmp;
			}
		}

		return res;
	}

}
