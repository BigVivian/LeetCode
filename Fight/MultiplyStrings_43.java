package Fight;

public class MultiplyStrings_43 {
	public String multiply(String num1, String num2) {

		// special condition
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		int len = num2.length();
		String res = "0";

		for (int i = len - 1; i >= 0; i--) {
			String tmpRes = multiplyDigit(num1, num2.charAt(i) - '0', len - i
					- 1);
			res = plus(res, tmpRes);
		}

		return res;
	}

	/**
	 * 
	 * @param num
	 * @param digit
	 * @param power
	 * @return num * digit * 10^power, where 0<=digit<=9
	 */
	public String multiplyDigit(String num, int digit, int power) {

		for (int i = 0; i <= power - 1; i++) {
			num += '0';
		}

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int len = num.length() - 1;
		while (len >= 0) {
			int curDigit = num.charAt(len) - '0';
			int tmpRes = curDigit * digit + carry;
			if (tmpRes >= 10) {
				carry = tmpRes / 10;
				tmpRes = tmpRes % 10;
			} else {
				carry = 0;
			}
			sb.insert(0, tmpRes);
			len--;
		}
		if (carry != 0) {
			sb.insert(0, carry);
		}

		return sb.toString();
	}

	/**
	 * return num1 + num2<br>
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String plus(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;
		int carry = 0;

		while (!((index1 < 0 && index2 < 0))) {
			int digit1;
			int digit2;

			digit1 = (index1 >= 0) ? (num1.charAt(index1) - '0') : 0;
			digit2 = (index2 >= 0) ? (num2.charAt(index2) - '0') : 0;

			if (digit1 + digit2 + carry >= 10) {
				sb.insert(0, digit1 + digit2 + carry - 10);
				carry = 1;
			} else {
				sb.insert(0, digit1 + digit2 + carry);
				carry = 0;
			}

			index1--;
			index2--;
		}
		if (carry == 1) {
			sb.insert(0, 1);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings_43 test = new MultiplyStrings_43();
		String res = test.multiply("99", "99");
		System.out.println(res);
	}

}
