package Fight;

public class PlusOne_66 {
	public int[] plusOne(int[] digits) {
		boolean carry = false;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == digits.length - 1) {
				digits[i] = digits[i] + 1;
				if (digits[i] >= 10) {
					carry = true;
					digits[i] -= 10;
				}
			} else {
				digits[i] = digits[i] + ((carry == false) ? 0 : 1);
				if (digits[i] >= 10) {
					carry = true;
					digits[i] -= 10;
				} else {
					carry = false;
				}
			}
		}

		int[] res = null;
		if (carry) {
			res = new int[digits.length + 1];
			res[0] = 1;
			for (int i = 1; i <= res.length - 1; i++) {
				res[i] = digits[i - 1];
			}
		} else {
			res = digits;
		}

		return res;
	}

	public static void main(String[] args) {
		PlusOne_66 test = new PlusOne_66();
		int[] digits = { 1, 2, 3 };
		int[] res = test.plusOne(digits);

		for (int i = 0; i <= res.length - 1; i++) {
			System.out.print(res[i]);
		}
	}
}
