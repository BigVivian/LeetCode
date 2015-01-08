package Fight;

/**
 * 
 * traverse the string from end to start
 * 
 * @author Vivian
 * 
 */
public class LengthofLastWord_58 {

	public int lengthOfLastWord(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		int index = s.length() - 1;
		int count = 0;
		while (index >= 0) {
			if (s.charAt(index) != ' ') {
				count++;
			} else {
				if (count != 0) {
					break;
				}
			}
			index--;
		}

		return count;
	}

	public static void main(String[] args) {
		LengthofLastWord_58 test = new LengthofLastWord_58();
		int res = test.lengthOfLastWord("kdjdfjajf ab     ");
		System.out.println(res);
	}

}
