package Fight;

/**
 * 剑指offer - 53
 * 
 * @author Vivian
 * 
 */
public class RegularExpressionMatching_10 {

	public boolean isMatch(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		if (p.length() == 1) {
			if (s.length() <= 0) {
				return false;
			}

			if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// Pattern[0] == '*'
		if (p.charAt(1) != '*') {
			if (s.length() <= 0) {
				return false;
			}
			if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// Pattern[1] == '*'
		else {
			// *匹配s中的0个字符
			if (isMatch(s, p.substring(2))) {
				return true;
			}

			// *匹配s中的i+1个字符
			int i = 0;
			while (i < s.length()
					&& (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}

	}

	public static void main(String[] args) {
		RegularExpressionMatching_10 test = new RegularExpressionMatching_10();
		boolean res = test.isMatch("baccbbcbcacacbbc", "c*.*b*c*ba*b*b*.a*");
		System.out.println(res);
	}
}