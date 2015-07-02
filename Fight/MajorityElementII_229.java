package Fight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode - 229 / Majority Element II / 求数组中元素个数大于n/3的数
 * 
 * @author Vivian
 * 
 */
public class MajorityElementII_229 {

	public List<Integer> majorityElement(int[] nums) {

		Set<Integer> set = new HashSet<Integer>();

		int m1 = -1, m2 = -1, c1 = 0, c2 = 0;

		// select the two majority number
		for (int num : nums) {
			if (set.size() == 0) {
				m1 = num;
				c1 = 1;
				set.add(m1);
			} else if (set.size() == 1 && !set.contains(num)) {
				m2 = num;
				c2 = 1;
				set.add(m2);
			} else {
				if (num == m1) {
					c1++;
				} else if (num == m2) {
					c2++;
				} else {
					c1--;
					c2--;

					if (c1 == 0) {
						set.remove(m1);
						c1 = c2;
						m1 = m2;
					}
					if (c2 == 0) {
						set.remove(m2);
					}
				}
			}

		}

		c1 = 0;
		c2 = 0;

		// count > n/3?
		for (int num : nums) {
			if (num == m1) {
				c1++;
			}
			if (set.size() == 2 && num == m2) {
				c2++;
			}
		}

		List<Integer> res = new ArrayList<Integer>();
		if (c1 > nums.length / 3)
			res.add(m1);

		if (c2 > nums.length / 3)
			res.add(m2);

		return res;

	}

	public static void main(String[] args) {
		int[] nums = { 0, -1, 2, -1 };
		MajorityElementII_229 test = new MajorityElementII_229();
		List<Integer> res = test.majorityElement(nums);

		for (int num : res) {
			System.out.print(num + " ");
		}
	}
}
