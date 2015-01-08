package Fight;

import java.math.BigInteger;

public class ClimbingStairs {

	// DP 思想
	/**
	 * 利用DP的方法，一个台阶的方法次数为1次，两个台阶的方法次数为2个。n个台阶的方法可以理解成上n-2个台阶，然后2步直接上最后一步；或者上n-1
	 * 个台阶，再单独上一步。 公式是S[n] = S[n-1] + S[n-2], S[1] = 1, S[2] = 2
	 * 
	 */

	public int climbStairs1(int n) {

		if (n <= 2) {
			return n;
		}

		int[] res = new int[n];
		res[0] = 1;
		res[1] = 2;
		for (int i = 2; i <= n - 1; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}

		return res[n - 1];
	}

	// 自己的方法
	public int climbStairs(int n) {

		if (n == 0) {
			return 0;
		}

		int res = 0;
		for (int i = n / 2; i >= 0; i--) {
			int twos = i;
			int ones = n - 2 * i;

			res += calcFactor1(twos + ones, twos, ones);
		}
		return res;
	}

	private int calcFactor1(int sum, int a, int b) {

		long res = 1;

		if (a == 0 || b == 0) {
			return 1;
		}

		int tmp = a > b ? a : b;
		for (int i = 1; i <= tmp; i++) {
			res = res * sum / i;
			sum--;
		}

		System.out.println("factor = " + res);

		return (int) res;
	}

	// leetcode没有BigInteger
	private String calcFactor(int sum, int a, int b) {

		BigInteger res = new BigInteger("1");

		if (a == 0 || b == 0) {
			return "1";
		}

		int tmp = a > b ? a : b;
		for (int i = 1; i <= tmp; i++) {
			res = res.multiply(new BigInteger(String.valueOf(sum))).divide(
					new BigInteger(String.valueOf(i)));
			sum--;
		}

		System.out.println("factor = " + res);

		return res.toString();
	}

	public static void main(String[] args) {
		ClimbingStairs test = new ClimbingStairs();
		int res = test.climbStairs(44);
		// test.climbStairs(44);
		System.out.println(res);
	}

}
