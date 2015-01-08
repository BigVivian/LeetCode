package Fight;

public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		String[] title = { "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
				"V", "W", "X", "Y" };
		if (n <= 0) {
			return "";
		} else {
			StringBuilder builder = new StringBuilder();
			while (n != 0) {
				int r = n % 26;
				n = n / 26;
				builder.append(title[r]);

				// 注意余数为0的情况
				if (r == 0) {
					n--;
				}
			}

			return builder.reverse().toString();
		}
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
		for (int n = 1; n <= 100; n++) {
			System.out.println(n + " = " + test.convertToTitle(n));
		}
	}
}
