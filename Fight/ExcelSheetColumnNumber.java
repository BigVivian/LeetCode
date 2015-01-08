package Fight;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int res = 0;
		for (int i = 0; i <= s.length() - 1; i++) {
			int current = s.charAt(i) - 'A' + 1;
			res = res * 26 + current;
		}
		return res;
	}

	public static void main(String[] args) {

	}

}
