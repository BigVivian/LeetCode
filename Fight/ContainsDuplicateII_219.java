package Fight;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Leetcode-219 / 判断数组中是否存在重复元素，且重复元素之间的距离不超过k
 * 
 * Given an array of integers and an integer k, return true if and only if there
 * are two distinct indices i and j in the array such that nums[i] = nums[j] and
 * the difference between i and j is at most k.
 * 
 * @author Vivian
 * 
 */
public class ContainsDuplicateII_219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {

		boolean hasDuplicate = false;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i <= nums.length - 1; i++) {
			if (map.containsKey(nums[i])) {
				hasDuplicate = true;
				if (i - map.get(nums[i]) > k) {
					return false;
				}
			} else {
				map.put(nums[i], i);
			}
		}

		return hasDuplicate;
	}

	public static void main(String[] args) {

	}

}
