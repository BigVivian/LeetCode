package Fight;

/**
 * Rules:<br>
 * 
 * 1.'?' Matches any single character. <br>
 * 2.'*' Matches any sequence of characters (including the empty sequence).
 * 
 * @author Vivian
 * 
 */
public class WildcardMatching_44 {
	public boolean isMatch2(String s, String p) {

		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1) {
			if (p.charAt(0) == '*') {
				return true;
			} else {
				if (s.length() == 0) {
					return false;
				}
				if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?') {
					return isMatch(s.substring(1), p.substring(1));
				} else {
					return false;
				}
			}
		}

		// Pattern[0] != '*'
		if (p.charAt(0) != '*') {
			if (s.length() == 0) {
				return false;
			}
			if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?') {
				return isMatch(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		}
		// Pattern[0] = '*'
		else {
			while (p.charAt(1) == '*') {
				p = p.substring(1);
			}
			// *匹配0个字符串
			if (isMatch(s, p.substring(1))) {
				return true;
			}

			int i = 0;
			while (i < s.length()) {
				if (isMatch(s.substring(i + 1), p)) {
					return true;
				}
				i++;
			}
			return false;
		}
	}

	public boolean isMatch(String s, String p) {

		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.charAt(0) == '*') {
			while (p.charAt(0) == '*') {
				p.substring(1);
			}

			if (p.length() == 0) {
				return true;
			}

			while (s.length() != 0 && !isMatch(s, p)) {
				s = s.substring(1);
			}

			return false;
		} else {
			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
				return isMatch(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		}

	}

	public static void main(String[] args) {
		WildcardMatching_44 test = new WildcardMatching_44();
		boolean res = test.isMatch(
				"babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab",
				"***bba**a*bbba**aab**b");

		System.out.println(res);
	}

}
