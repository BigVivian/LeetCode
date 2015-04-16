package Fight;

/**
 * 给定数组A，数x出现1次，其他数均出现3次，求x
 * 
 * 方法1:数组保存各个数位的1的个数<br>
 * 方法2:使用bitmask? <br>
 * https://leetcode.com/discuss/857/constant-space-solution
 * 
 * @author Vivian
 * 
 */
public class SingleNumberII_137 {

	// 方法1:使用int数组保存每个位上1出现的次数
	public int singleNumber(int[] A) {
		int[] bits = new int[32];
		for (int i = 0; i <= bits.length - 1; i++) {
			bits[i] = 0;
		}

		// 依次计算每个数值中1出现的次数
		for (int i = 0; i <= A.length - 1; i++) {
			for (int j = 0; j <= 31; j++) {
				bits[j] += (A[i] >> j) & 1;
			}
		}

		// 用3模
		int res = 0;
		for (int i = 0; i <= 31; i++) {
			res |= bits[i] % 3 << i;
		}

		return res;
	}

	/**
	 * ones as a bitmask to represent the ith bit had appeared once. <br>
	 * twos as a bitmask to represent the ith bit had appeared twice.<br>
	 * threes as a bitmask to represent the ith bit had appeared three times. <br>
	 * When the ith bit had appeared for the third time, clear the ith bit of
	 * both ones and twos to 0. <br>
	 * The final answer will be the value of ones.
	 * 
	 */
	public int singleNumber2(int[] A) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i <= A.length - 1; i++) {
			twos |= ones & A[i];
			ones ^= A[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 1, 2, 3, 3, 1, 2, 3, 6 };
		SingleNumberII_137 test = new SingleNumberII_137();
		int res = test.singleNumber2(A);

		System.out.println(res);
	}

}
