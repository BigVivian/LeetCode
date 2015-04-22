package Fight;

import java.util.HashSet;
import java.util.Set;

/**
 * 求一个数是否为Happy Number
 * 
 * Happy Number定义如下：<br>
 * 
 * Example: 19 is a happy number<br>
 * 1^2 + 9^2 = 82<br>
 * 8^2 + 2^2 = 68<br>
 * 6^2 + 8^2 = 100<br>
 * 1^2 + 0^2 + 0^2 = 1<br>
 * 
 * @author Vivian
 * 
 */
public class HappyNumber_202 {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();

		while (n != 1) {
			n = getNBitSquare(n);

			if (set.contains(n)) {
				break;
			} else {
				set.add(n);
			}
		}

		if (n == 1) {
			return true;
		} else {
			return false;
		}
	}

	private int getNBitSquare(int n) {
		int res = 0;

		int cur = 0;
		while (n != 0) {
			cur = n % 10;
			res += cur * cur;
			n = n / 10;
		}

		return res;
	}

	public static void main(String[] args) {

	}

}
