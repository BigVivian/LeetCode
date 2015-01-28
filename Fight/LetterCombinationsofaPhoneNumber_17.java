package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * BackTracking<br>
 * 
 * @author Vivian
 * 
 */
public class LetterCombinationsofaPhoneNumber_17 {

	List<String> res;
	char[] str;
	String[] index;

	public List<String> letterCombinations(String digits) {
		initIndex();
		res = new ArrayList<String>();
		str = new char[digits.length()];

		combine(0, digits.length(), digits);

		return res;
	}

	private void combine(int cur, int n, String digits) {
		if (cur == n) {
			res.add(String.valueOf(str));
		} else {
			int currentDigit = digits.charAt(cur) - '0';
			// System.out.println(currentDigit);
			for (int i = 0; i <= index[currentDigit].length() - 1; i++) {
				str[cur] = index[currentDigit].charAt(i);
				combine(cur + 1, n, digits);
			}
		}
	}

	private void initIndex() {
		index = new String[12];
		index[2] = "abc";
		index[3] = "def";
		index[4] = "ghi";
		index[5] = "jkl";
		index[6] = "mno";
		index[7] = "pqrs";
		index[8] = "tuv";
		index[9] = "wxyz";
	}

	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber_17 test = new LetterCombinationsofaPhoneNumber_17();
		List<String> res = test.letterCombinations("239");
		for (String tmp : res) {
			System.out.print("\"" + tmp + "\",");
		}
	}

}
