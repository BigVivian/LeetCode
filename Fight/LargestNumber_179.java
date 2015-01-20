package Fight;

/**
 * swap and sort<br>
 * 
 * Tip: it might overflow if use Integer.valueOf(String)<br>
 * 
 * @author Vivian
 * 
 */
public class LargestNumber_179 {
	public String largestNumber(int[] num) {

		String[] arrs = new String[num.length];
		for (int i = 0; i <= num.length - 1; i++) {
			arrs[i] = String.valueOf(num[i]);
		}

		for (int i = 0; i <= arrs.length - 2; i++) {
			for (int j = i; j <= arrs.length - 1; j++) {
				if (needSwap(arrs[i], arrs[j])) {
					String tmp = arrs[i];
					arrs[i] = arrs[j];
					arrs[j] = tmp;
				}
			}
		}

		// concat the string
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= num.length - 1; i++) {
			sb.append(arrs[i]);
		}

		// remove extra zeros
		if (sb.charAt(0) == '0') {
			return "0";
		}

		return sb.toString();
	}

	private boolean needSwap(String a, String b) {

		String ab = a.concat(b);
		String ba = b.concat(a);

		for (int i = 0; i <= ab.length() - 1; i++) {
			if (ab.charAt(i) > ba.charAt(i)) {
				return false;
			} else if (ab.charAt(i) < ba.charAt(i)) {
				return true;
			} else {
				continue;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		int[] num = { 1, 2 };

		LargestNumber_179 test = new LargestNumber_179();
		String res = test.largestNumber(num);
		System.out.println(res);
	}

}
