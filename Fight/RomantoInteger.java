package Fight;

public class RomantoInteger {
	public int romanToInt(String s) {
		int num = 0;

		for (int i = 0; i <= s.length() - 1; i++) {
			if ((i <= s.length() - 2)
					&& (charToInt(s.charAt(i)) < charToInt(s.charAt(i + 1)))) {
				num += charToInt(s.charAt(i + 1)) - charToInt(s.charAt(i));
				i++;
			} else {
				num += charToInt(s.charAt(i));
			}
		}

		return num;
	}

	private int charToInt(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		RomantoInteger test = new RomantoInteger();
		int result = test.romanToInt("DCXXI");
		System.out.println(result);
	}
}
