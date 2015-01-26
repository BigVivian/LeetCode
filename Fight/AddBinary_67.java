package Fight;

/**
 * Add two binary
 * 
 * @author Vivian
 * 
 */
public class AddBinary_67 {
	public String addBinary(String a, String b) {

		int lenA = a.length();
		int lenB = b.length();
		StringBuffer sb = new StringBuffer();
		boolean carry = false;

		for (int i = lenA - 1, j = lenB - 1; i >= 0 || j >= 0; i--, j--) {
			int tmp = (i >= 0 ? a.charAt(i) - '0' : 0)
					+ (j >= 0 ? b.charAt(j) - '0' : 0) + (carry ? 1 : 0);
			if (tmp > 1) {
				carry = true;
				tmp -= 2;
			} else {
				carry = false;
			}
			sb.append(tmp);
		}
		if (carry) {
			sb.append(1);
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		AddBinary_67 test = new AddBinary_67();
		String res = test.addBinary("1110", "11");
		System.out.println(res);
	}
}
