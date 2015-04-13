package Fight;

import java.util.Stack;

/**
 * 返回左右括号的最长匹配，如s=")()())",则最长匹配为"()()",长度为4
 * 
 * 方法1:使用栈记录左括号，用flag数组标识匹配上的左右括号，再遍历一次flag数组，求出max <br>
 * 方法2:动态求解，从后往前计算最长匹配长度
 * 
 * @author Vivian
 * 
 */

public class LongestValidParentheses_32 {
	public int longestValidParentheses(String s) {
		int max = 0;

		boolean[] flag = new boolean[s.length()];
		for (int i = 0; i <= s.length() - 1; i++) {
			flag[i] = false;
		}

		// 使用栈辅助记录已匹配的左右括号
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i <= s.length() - 1; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					flag[i] = true;
					flag[stack.pop()] = true;
				}
			}
		}

		// 比较最长的匹配
		int count = 0;
		for (int i = 0; i <= s.length() - 1; i++) {
			if (flag[i]) {
				count++;
			} else {
				count = 0;
			}
			max = count > max ? count : max;
		}

		return max;
	}

	public int longestValidParentheses2(String s) {
		int max = 0;

		// dp[i]表示从s[i]到s[s.length - 1]包含s[i]的最长的有效匹配括号子串长度
		int[] dp = new int[s.length()];
		for (int i = 0; i <= s.length() - 1; i++) {
			dp[i] = 0;
		}

		int len = s.length();

		// 从len-2开始，逆向求最长的匹配
		/**
		 * 若s[i]=='('<br>
		 * step 1:在字符串s中寻找从i+1开始,跳过最长匹配后的字符s[j],其中j=i+1+dp[i+1]<br>
		 * ******若j未越界 && s[j]==')',则dp[i] = dp[i+1] + 2;<br>
		 * step 2:现已求得s[i...j]的最长有效匹配长度，若j+1没有越界，则dp[i] += dp[j+1];
		 */
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				int j = i + 1 + dp[i + 1];
				if (j <= len - 1 && s.charAt(j) == ')') {
					dp[i] = dp[i + 1] + 2;
					if (j + 1 <= len - 1) {
						dp[i] += dp[j + 1];
					}
				}

			}
			max = dp[i] > max ? dp[i] : max;
		}

		return max;
	}

	public static void main(String[] args) {
		String s = ")))(((((())";
		LongestValidParentheses_32 test = new LongestValidParentheses_32();
		int res = test.longestValidParentheses(s);
		System.out.println(res);
	}

}
