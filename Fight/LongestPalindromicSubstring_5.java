package Fight;

/**
 * 求字符串中的最长回文子串<br>
 * 
 * flag[i][j]用于标识字符串i-字符串j之间的子串是否为回文子串<br>
 * 
 * 1.1 若i==j, flag[i][j] = true;<br>
 * 1.2 若j-i==1, flag[i][j] = (s[i] == s[j]);<br>
 * 1.3 否则, flag[i][j] = (s[i] == s[j]) && (flag[i+1][j-1]);
 * 
 * @author Vivian
 * 
 */
public class LongestPalindromicSubstring_5 {
	public String longestPalindrome(String s) {
		int len = s.length();
		boolean[][] flag = new boolean[len][len];

		int max = 1, start = 0, end = 0;
		for (int j = 1; j <= len - 1; j++) {
			flag[j][j] = true;

			for (int i = 0; i < j; i++) {
				if (j - i == 1) {
					flag[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					flag[i][j] = (s.charAt(i) == s.charAt(j))
							&& flag[i + 1][j - 1];
				}

				// 找到更长的回文子串
				if (flag[i][j] == true && j - i + 1 > max) {
					max = j - i + 1;
					start = i;
					end = j;
				}
			}
		}

		return s.substring(start, end + 1);
	}

	public static void main(String[] args) {
		String s = "abccccdaccccd";
		LongestPalindromicSubstring_5 test = new LongestPalindromicSubstring_5();
		String res = test.longestPalindrome(s);
		System.out.println(res);
	}

}
