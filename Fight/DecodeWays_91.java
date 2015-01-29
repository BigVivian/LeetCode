package Fight;

/**
 * 1.recursive : time exceed<br>
 * 2.
 * 
 * @author Vivian
 * 
 */
public class DecodeWays_91 {
	public int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		} else {
			return decodings(s, 0, s.length() - 1);
		}
	}

	public int decodings(String s, int start, int end) {
		if (end < start) {
			return 1;
		}
		if (end - start == 0) {
			return 1;
		}

		int value = (s.charAt(end - 1) - '0') * 10 + s.charAt(end) - '0';
		if (end - start == 1) {
			if (value <= 26 && value >= 11) {
				return 2;
			}
		}
		if (value <= 26 && value >= 11) {
			return decodings(s, start, end - 1) + decodings(s, start, end - 2);
		} else {
			if (s.charAt(end) - '0' == 0) {
				return decodings(s, start, end - 2);
			} else {
				return decodings(s, start, end - 1);
			}
		}

	}

	public static void main(String[] args) {
		DecodeWays_91 test = new DecodeWays_91();
		int res = test
				.numDecodings("7893749912342187894921836847319981199844151766195952528631828655978178193192959793156142441128167383");
		System.out.println(res);
	}

}
