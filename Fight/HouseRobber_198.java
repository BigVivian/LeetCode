package Fight;

/**
 * LeetCode -198 / House Robber / 不能取相邻的数，求组合的最大值
 * <p/>
 * 对于第N个房间
 * take num[N-1], dp[N] = num[N-1] + dpNonTake[N-1]
 * no num[N-1], dp[N] = dp[N-1]
 * <p/>
 * dp[N] = Math.max(num[N-1] + dpNonTake[N-1], dp[N-1])
 */
public class HouseRobber_198 {

    // one solution
    public int rob(int[] nums) {

        int take = 0;
        int noTake = 0;
        int max = 0;

        for (int i = 0; i <= nums.length - 1; i++) {
            take = noTake + nums[i];
            noTake = max;
            max = Math.max(take, noTake);
        }

        return max;
    }

    // the other
    public int rob2(int[] num) {
        int len = num.length;

        if (len == 0)
            return 0;

        if (len == 1)
            return num[0];

        int a = 0;
        int b = num[0];
        int c = num[1];
        for (int i = 2; i < len; i++) {
            int cur = Math.max(a, b) + num[i];
            a = b;
            b = c;
            c = cur;
        }
        return Math.max(c, b);
    }
}
