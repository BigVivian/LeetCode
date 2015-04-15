package Fight;

/**
 * 给定两个字符串，计算两个字符串之间的距离<br>
 * 
 * 动态规划(Dynamic Programming) <br>
 * if x == y, then dp[i][j] == dp[i-1][j-1] <br>
 * if x != y, and we insert y for word1, then dp[i][j] = dp[i][j-1] + 1<br>
 * if x != y, and we delete x for word1, then dp[i][j] = dp[i-1][j] + 1 <br>
 * if x != y, and we replace x with y for word1, then dp[i][j]= dp[i-1][j-1] + 1<br>
 * When x!=y, dp[i][j] is the min of the three situations.
 * 
 * http://www.programcreek.com/2013/12/edit-distance-in-java/
 * 
 * @author Vivian
 * 
 */
public class EditDistance_72 {
	public int minDistance(String word1, String word2) {

		int len1 = word1.length();
		int len2 = word2.length();

		int[][] dp = new int[len1 + 1][len2 + 1];

		// init
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		for (int i = 0; i <= len1 - 1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j <= len2 - 1; j++) {
				char c2 = word2.charAt(j);
				if (c1 == c2) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int insert = dp[i + 1][j] + 1;
					int delete = dp[i][j + 1] + 1;
					int replace = dp[i][j] + 1;

					dp[i + 1][j + 1] = min(insert, delete, replace);
				}
			}
		}

		return dp[len1][len2];
	}

	private int min(int a, int b, int c) {
		int min = a;

		min = b < min ? b : min;
		min = c < min ? c : min;

		return min;
	}

	public static void main(String[] args) {
		EditDistance_72 test = new EditDistance_72();
		int res = test.minDistance("aaabbbcd", "aaac");
		System.out.println(res);
	}

}
