package Fight;

import java.util.HashSet;

/**
 * Leetcode-271 / Contains Duplicate
 * <p/>
 * 判断一个数组是否包含重复的元素
 */
public class ContainsDuplicate_271 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }

        return false;
    }
}
