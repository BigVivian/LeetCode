package Fight;

// 提前检测是否溢出

public class ReverseInteger {
	public int reverse(int x) {

		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;

		int res = 0;

		while (x != 0) {
			int remain = x % 10;

			if (remain < 0 && res < (min - remain) / 10) {
				return 0;
			}
			if (remain > 0 && res > (max - remain) / 10) {
				return 0;
			}
			res = res * 10 + remain;

			x = x / 10;
		}

		return res;
	}

	public static void main(String[] args) {
		ReverseInteger test = new ReverseInteger();
		int res = test.reverse(123);
		System.out.println(res);
	}

}
