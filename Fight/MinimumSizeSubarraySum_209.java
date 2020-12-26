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
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }

        return (res == Integer.MAX_VALUE)? 0: res;
    }
}
