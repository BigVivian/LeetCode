package Fight;

public class ClimbingStairs_70 {

	// DP 思想
	/**
	 * 利用DP的方法，一个台阶的方法次数为1次，两个台阶的方法次数为2个。n个台阶的方法可以理解成上n-2个台阶，然后2步直接上最后一步；或者上n-1
	 * 个台阶，再单独上一步。 公式是S[n] = S[n-1] + S[n-2], S[1] = 1, S[2] = 2
	 * 
	 */

	public int climbStairs(int n) {
		if(n == 1) return 1;
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}


	public static void main(String[] args) {
		ClimbingStairs_70 test = new ClimbingStairs_70();
		int res = test.climbStairs(44);
		// test.climbStairs(44);
		System.out.println(res);
	}

}
