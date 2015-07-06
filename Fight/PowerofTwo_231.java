package Fight;

/**
 * LeetCode -231 / Power of Two / 判断一个数是否为2的N次幂
 * 
 * @author Vivian
 * 
 */
public class PowerofTwo_231 {
	public boolean isPowerOfTwo(int n) {

		if (n <= 0) {
			return false;
		}

		if (n == 1) {
			return true;
		}

		// 按位与
		int x = 1;
		while (x < n) {
			if ((x & n) != 0) {
				return false;
			}
			x = x << 1;
		}

		if (x >= n) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int n = 0;
		PowerofTwo_231 test = new PowerofTwo_231();
		boolean res = test.isPowerOfTwo(n);
		System.out.println(" *** " + res);
	}

}
