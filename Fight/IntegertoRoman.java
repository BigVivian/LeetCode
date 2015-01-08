package Fight;

public class IntegertoRoman {
	public String intToRoman(int num) {

		String res = "";
		int count = 1;

		while (num != 0) {
			int r = num % 10;

			StringBuilder sb = new StringBuilder();
			switch (r) {
			case 1:
			case 2:
			case 3:
				for (int i = 0; i <= r - 1; i++) {
					sb.append(IntToChar(1 * count));
				}
				break;
			case 4:
				sb.append(IntToChar(1 * count));
				sb.append(IntToChar(5 * count));
				break;
			case 5:
			case 6:
			case 7:
			case 8:
				sb.append(IntToChar(5 * count));
				for (int i = 0; i <= r - 5 - 1; i++) {
					sb.append(IntToChar(1 * count));
				}
				break;
			case 9:
			case 10:
				for (int i = 0; i <= 10 - r - 1; i++) {
					sb.append(IntToChar(1 * count));
				}
				sb.append(IntToChar(10 * count));
				break;
			}

			num = num / 10;
			count *= 10;

			res = sb + res;
		}

		return res;
	}

	private char IntToChar(int num) {
		switch (num) {
		case 1:
			return 'I';
		case 5:
			return 'V';
		case 10:
			return 'X';
		case 50:
			return 'L';
		case 100:
			return 'C';
		case 500:
			return 'D';
		case 1000:
			return 'M';
		default:
			return ' ';
		}
	}

	public static void main(String[] args) {
		IntegertoRoman test = new IntegertoRoman();
		String res = test.intToRoman(1976);
		System.out.println(res);
	}
}
