package Fight;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) {
			return true;
		}
		s = s.toLowerCase();

		int one = 0;
		int two = s.length() - 1 - one;
		while (one <= two) {
			while (one <= s.length() - 1 && !isAlphabetNumberic(s.charAt(one))) {
				one++;
			}
			while (two >= 0 && !isAlphabetNumberic(s.charAt(two))) {
				two--;
			}
			if (one >= s.length() || two < 0) {
				return true;
			}
			if (s.charAt(one) != s.charAt(two)) {
				return false;
			} else {
				one++;
				two--;
			}
		}

		return true;
	}

	private boolean isAlphabetNumberic(char ch) {
		if ((ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A')
				|| (ch <= '9' && ch >= '0')) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		ValidPalindrome test = new ValidPalindrome();
		// race a car
		// A man, a plan, a canal: Panama
		boolean res = test.isPalindrome("0k.;r0.k;");
		System.out.println(res);
	}
}
