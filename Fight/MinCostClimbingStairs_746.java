package Fight;

public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] dp = new int[size];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < size; i++) {
            dp[i] = Math.min(cost[i] + dp[i-1], cost[i] + dp[i-2]);
        }

        return Math.min(dp[size - 1], dp[size - 2]);
    }
}
