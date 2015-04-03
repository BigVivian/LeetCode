package Fight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组，求其中三个元素的值为0的不重复的组合
 * 
 * Two Pointers问题
 * 
 * @solution 转化为2Sum问题，a+b+c=0相当于a+b=-c问题<br>
 *           1.将数组排序<br>
 *           2.对于每个a[i], 寻找[i+1,n-1]中，使得a[k1]+a[k2]=-a[i]的组合<br>
 *           3.寻找组合时，用left和right分别指向开始和结束<br>
 *           3.1.如果a[k1]+a[k2]+a[i]<0，则left++<br>
 *           3.2.如果a[k1]+a[k2]+a[i]>0，则right--<br>
 * 
 * @author Vivian
 * 
 */
public class Sum3_15 {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> threeSum(int[] num) {

		if (num == null || num.length < 3) {
			return res;
		}
		Arrays.sort(num);

		for (int i = 0, len = num.length; i <= len - 3; i++) {

			// 排除相同的组合
			if (i >= 1 && num[i] == num[i - 1])
				continue;
			find(num, i + 1, len - 1, num[i]);
		}

		return res;
	}

	// 转化成2Sum,目标为target
	private void find(int[] num, int begin, int end, int target) {

		int left = begin;
		int right = end;

		while (left < right) {
			int sum = num[left] + num[right] + target;
			if (sum == 0) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(target);
				list.add(num[left]);
				list.add(num[right]);

				res.add(list);

				while (left < right && num[left] == num[left + 1]) {
					left++;
				}
				while (left < right && num[right] == num[right - 1]) {
					right--;
				}
				left++;
				right--;
			} else if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { -1, 0, 1, 2, -1, -4 };
		Sum3_15 test = new Sum3_15();
		List<List<Integer>> res = test.threeSum(num);

		System.out.println("****");
	}
}
