package Fight;

/**
 * LeetCode - 209 / Minimum Size Subarray Sum
 * <p/>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * <p/>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {

        int start = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - 1; i++) {
            count += nums[i];

            if (count >= s) {
                min = Math.min(min, i - start + 1);
                while (count - nums[start] >= s) {
                    count -= nums[start];
                    start++;
                    min = Math.min(min, i - start + 1);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return 0;
        }

        return min;
    }
}
