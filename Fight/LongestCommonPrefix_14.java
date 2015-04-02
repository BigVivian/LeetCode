package Fight;

/**
 * 求N个字符串的最长前缀
 * 
 * @author Vivian
 * 
 */
public class LongestCommonPrefix_14 {
	public String longestCommonPrefix(String[] strs) {

		if (strs.length <= 0) {
			return "";
		}

		String prefix = strs[0];
		String temp = null;

		for (int i = 1; i <= strs.length - 1; i++) {
			temp = strs[i];

			int len = Math.min(temp.length(), prefix.length());
			if (len <= 0)
				return "";

			int j = 0;
			for (j = 0; j <= len - 1 && prefix.charAt(j) == temp.charAt(j); j++) {
				;
			}

			prefix = prefix.substring(0, j);
		}

		return prefix;
	}

	public static void main(String[] args) {

	}

}
