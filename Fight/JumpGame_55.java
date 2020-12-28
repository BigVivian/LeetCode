package Fight;

/**
 * LeetCode - 55
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0; i<=max && i<=nums.length-2; i++){
            max = Math.max(nums[i]+i, max);
        }

        if(max < nums.length -1)
            return false;

        return true;
    }

    // Greedy solution
    public boolean canJump_2(int[] nums) {
        int lastPos = nums.length - 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        return lastPos == 0;
    }

    // bottom-up dynamic programming
    enum Index{
        GOOD, BAD, UNKNOWN
    }

    public boolean canJump_3(int[] nums) {
        Index[] memo = new Index[nums.length];
        for(int i = 0; i < nums.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[nums.length - 1] = Index.GOOD;

        for(int i = nums.length - 2; i >= 0; i--) {
            int furthest = Math.min(i + nums[i], nums.length - 1);
            for(int next = i + 1; next <= furthest; next++) {
                if(memo[next] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }
}
