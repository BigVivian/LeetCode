package Fight;

import java.util.HashSet;
import java.util.Set;

/**
 * 求出字符串S能否用wordDict中的字符表示<br>
 * 
 * 动态规划
 * 
 * @author Vivian
 * 
 */
public class WordBreak_139 {
	public boolean wordBreak(String s, Set<String> wordDict) {

		// 初始化
		boolean[] dp = new boolean[s.length() + 1];
		for (int i = 0; i <= dp.length - 1; i++) {
			dp[i] = false;
		}
		dp[0] = true;

		// 遍历
		for (int i = 0; i <= s.length() - 1; i++) {
			if (dp[i]) {
				for (int len = 1; i + len <= s.length(); len++) {
					// 如果存在 i~i+len的字符，则将dp[i + len] = true;
					if (wordDict.contains(s.substring(i, i + len))) {
						dp[i + len] = true;
					}
				}
			}

		}

		return dp[s.length()];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");

		WordBreak_139 test = new WordBreak_139();
		boolean res = test.wordBreak(s, wordDict);
	}

}
