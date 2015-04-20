package Fight;

import java.util.Stack;

/**
 * 给定一组图表的高度，求这些图表组成的最大的矩形的面积
 * 
 * 将数组化简为递增的数据
 * 
 * 1.height[i] > stackHeight.peek(),压入栈
 * 
 * 2.height[i] == stackHeight.peek(),ignore
 * 
 * 3.height[i] < stackHeight.peek()<br>
 *** 3.1 pop出栈中所有比height[i]大的数 <br>
 *** 3.2 计算当前组成的面积 <br>
 *** 3.3 重复1,2 最后压入height[i] 其中index需要改为最后一个比height[i]大的数的index<br>
 * 
 * @author Vivian
 * 
 */
public class LargestRectangleinHistogram_84 {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length <= 0) {
			return 0;
		}

		int max = 0;
		Stack<Integer> stackHeight = new Stack<Integer>();
		Stack<Integer> stackIndex = new Stack<Integer>();

		for (int i = 0; i <= height.length - 1; i++) {
			// stack is empty
			if (stackHeight.isEmpty()) {
				stackHeight.push(height[i]);
				stackIndex.push(i);
			}

			// stack is not empty
			if (height[i] > stackHeight.peek()) {
				stackHeight.push(height[i]);
				stackIndex.push(i);
			} else if (height[i] < stackHeight.peek()) {

				// 弹出所有比height[i]的数据
				int lastIndex = 0;
				while (!stackHeight.isEmpty() && height[i] < stackHeight.peek()) {
					lastIndex = stackIndex.pop();
					int temp = stackHeight.pop() * (i - lastIndex);
					max = temp > max ? temp : max;
				}

				stackHeight.push(height[i]);
				stackIndex.push(lastIndex);
			}

		}

		// finish adding all points
		while (!stackHeight.isEmpty()) {
			int temp = stackHeight.pop() * (height.length - stackIndex.pop());
			max = temp > max ? temp : max;
		}

		return max;
	}

	public static void main(String[] args) {
		int[] height = { 2, 1, 2 };

		LargestRectangleinHistogram_84 test = new LargestRectangleinHistogram_84();
		int res = test.largestRectangleArea(height);

		System.out.println(res);
	}
}
