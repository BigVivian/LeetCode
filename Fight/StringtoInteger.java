package Fight;

public class StringtoInteger {
	public int atoi(String str) {

		str = str.trim();
		if (str == null || str.isEmpty()) {
			return 0;
		}

		long res = 0;
		int flag = 1;
		for (int i = 0; i <= str.length() - 1; i++) {

			char ch = str.charAt(i);
			if (i == 0 && ch == '-') {
				flag = -1;
			} else if (i == 0 && ch == '+') {
				flag = 1;
			} else if (ch <= '9' && ch >= '0') {
				int num = ch - '0';
				if (flag == -1)
					num = num * (-1);

				if ((res * 10 + num) > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if ((res * 10 + num) <= Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				} else {
					res = res * 10 + num;
				}
			} else {
				break;
			}

		}

		return (int) res;

	}

	public static void main(String[] args) {
		StringtoInteger test = new StringtoInteger();
		int res = test.atoi("2147483648");
		System.out.println(res);
	}

}
