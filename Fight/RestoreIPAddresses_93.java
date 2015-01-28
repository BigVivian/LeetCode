package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * BackTracking<br>
 * Tips:multi zeros<br>
 * 
 * @author Vivian
 * 
 */
public class RestoreIPAddresses_93 {

	List<String> res;
	int[] mac;

	public List<String> restoreIpAddresses(String s) {
		res = new ArrayList<String>();
		mac = new int[4];

		if (s == null || s.length() < 4 || s.length() > 12) {
			return res;
		}

		restore(0, 4, 0, s);

		return res;
	}

	private void restore(int cur, int n, int index, String s) {
		if (cur == n) {
			if (index == s.length()) {
				String tmp = mac[0] + "." + mac[1] + "." + mac[2] + "."
						+ mac[3];
				res.add(tmp);
			}
		} else {
			for (int i = 1; i <= 3; i++) {
				// System.out.println(index + "~" + (index + i));
				if (index >= s.length() || index + i > s.length()) {
					break;
				}

				mac[cur] = Integer.valueOf(s.substring(index, index + i));
				// System.out.println("mac[" + cur + "]= " + mac[cur]);

				if (isValid(cur)) {
					restore(cur + 1, n, index + i, s);
				}

				if (s.charAt(index) - '0' == 0) {
					break;
				}
			}
		}
	}

	private boolean isValid(int cur) {
		for (int i = 0; i <= cur; i++) {
			if (mac[i] > 255) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		RestoreIPAddresses_93 test = new RestoreIPAddresses_93();
		List<String> res = test.restoreIpAddresses("010010");
		for (String tmp : res) {
			System.out.print("\"" + tmp + "\",");
		}
	}

}
