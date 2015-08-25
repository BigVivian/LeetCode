package Fight;

/**
 * LeetCode - 268 / Missging Number / 找出N个数中消失的数
 * <p/>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i <= len - 1; i++) {
            count += nums[i];
        }

        int tmp = len * (len + 1) / 2;

        return tmp - count;
    }
}
