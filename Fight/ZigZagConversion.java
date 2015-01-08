package Fight;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i <= nRows - 1; i++) {
			int group = (nRows - 1) * 2;
			int[] margin = { group - 2 * i, 2 * i };

			if (margin[0] == 0 || margin[1] == 0) {
				int current = i;
				while (current <= s.length() - 1) {
					builder.append(s.charAt(current));
					current += group;
				}
			} else {
				int count = 0;
				int current = i;
				while (current <= s.length() - 1) {
					builder.append(s.charAt(current));
					current += margin[count % 2];
					count++;
				}
			}
		}

		return builder.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion test = new ZigZagConversion();
		String result = test.convert("A", 1);
		System.out.println(result);
	}
}
