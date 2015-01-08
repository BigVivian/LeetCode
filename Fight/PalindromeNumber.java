package Fight;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;

		int div = 1;
		while (x / div >= 10) {
			div *= 10;// calculate digits
		}

		while (x >= 10) {
			int left = x / div;
			int right = x % 10;
			if (left != right) {
				return false;
			}
			x = (x % div) / 10;// without left and right
			div = div / 100;
		}
		if (div == 1) {
			return true;
		} else {
			if (x == 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	// 注意结束条件和边界
	public boolean isPalindrome2(int x) {
		if (x < 0)
			return false;

		int div = 1;
		while (x / div >= 10) {
			div *= 10;// calculate digits
		}

		while (x != 0) {
			int left = x / div;
			int right = x % 10;
			if (left != right) {
				return false;
			}
			x = (x % div) / 10;// without left and right
			div = div / 100;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeNumber test = new PalindromeNumber();
		boolean res = test.isPalindrome2(1000021);
		System.out.println(res);
	}

}
