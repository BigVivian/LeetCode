package Fight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode-18 / 4Sum / 求四个数之和为target的组合
 * 
 * @author Vivian
 * 
 */
public class Sum4_18 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();

		for (int i = 0; i <= nums.length - 1; i++) {
			for (int j = i + 1; j <= nums.length - 1; j++) {
				int p = j + 1;
				int q = nums.length - 1;

				while (q > p) {
					int sum = nums[i] + nums[j] + nums[p] + nums[q];

					if (sum > target) {
						q--;
					} else if (sum < target) {
						p++;
					} else if (sum == target) {
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[p]);
						tmp.add(nums[q]);

						if (!set.contains(tmp)) {
							set.add(tmp);
							res.add(tmp);
						}

						p++;
						q--;
					}
				}
			}
		}

		return res;
	}

}
