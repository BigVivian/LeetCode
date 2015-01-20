package Fight;

/**
 * two way search
 * 
 * @author Vivian
 * 
 */
public class Candy_135 {

	public int candy(int[] ratings) {

		int len = ratings.length;
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return 1;
		}

		int[] candys = new int[len];

		candys[0] = 1;
		for (int i = 1; i <= len - 1; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candys[i] = candys[i - 1] + 1;
			} else {
				candys[i] = 1;
			}
		}

		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && candys[i] <= candys[i + 1]) {
				candys[i] = candys[i + 1] + 1;
			}

		}

		int sum = 0;
		for (int i = 0; i <= candys.length - 1; i++) {
			System.out.print(candys[i] + ",");
			sum += candys[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] rates = { 2, 2, 1 };
		Candy_135 test = new Candy_135();
		int res = test.candy(rates);
		System.out.println("\nres = " + res);
	}
}
