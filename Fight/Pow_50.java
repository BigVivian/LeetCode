package Fight;

/**
 * 求数x的n次幂，要求在O(logN)的时间内
 * 
 * Consider the binary representation of n.<br>
 * For example, if it is "10001011", <br>
 * then x^n = x^(1+2+8+128) = x^1 * x^2 * x^8 * x^128.<br>
 * Thus, we don't want to loop n times to calculate x^n.<br>
 * To speed up, we loop through each bit, <br>
 * if the i-th bit is 1, then we add x^(1 << i) to the result. <br>
 * Since (1 << i) is a power of 2, x^(1<<(i+1)) = square(x^(1<<i)). <br>
 * The loop executes for a maximum of log(n) times.
 * 
 * refs -- http://www.tuicool.com/articles/YfauEn
 * 
 * @author Vivian
 * 
 */
public class Pow_50 {

	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		// n为Integer.MIN_VALUE时，求绝对值后将超出整数表示的范围
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				return 1 / (pow(x, Integer.MAX_VALUE) * x);
			} else {
				return 1 / pow(x, -n);
			}
		}

		double res = 1;
		while (n > 0) {
			int bit = n & 1;
			if (bit > 0) {
				res *= x;
			}

			n = n >> 1;
			x *= x;
		}

		return res;
	}

	public static void main(String[] args) {

	}

}
