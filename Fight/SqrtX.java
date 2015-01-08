package Fight;

//二分法效率更高
// int相乘溢出情况需要考虑
public class SqrtX {
	public int sqrt(int x) {

		if (x < 0) {
			return -1;
		}
		if (x == 0) {
			return 0;
		}

		int beforeCmpRes = 0;
		int res = x / 2;

		int curRes = res * res;
		while (true) {
			curRes = res * res;
			if (curRes == x) {
				break;
			} else if (curRes > x) {
				if (beforeCmpRes == -1) {
					res--;
					break;
				}
				beforeCmpRes = 1;
				res--;
			} else {
				if (beforeCmpRes == 1) {
					break;
				}
				beforeCmpRes = -1;
				res++;
			}
		}

		return res;

	}

	public int sqrt2(int x) {
		if (x < 0)
			return -1;
		if (x == 0) {
			return 0;
		}

		int start = 0;
		int end = x;
		int res = (start + end) / 2;

		while (end >= start) {
			long tmp = (long) res * res;

			if (tmp == x) {
				break;
			}
			if (tmp > x) {
				end = res - 1;
			}
			if (tmp < x) {
				start = res + 1;
			}

			res = (start + end) / 2;
		}

		return res;
	}

	public static void main(String[] args) {
		SqrtX test = new SqrtX();
		int res = test.sqrt2(100);
		System.out.println(res);
	}

}
