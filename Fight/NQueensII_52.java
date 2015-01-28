package Fight;

public class NQueensII_52 {
	private int sum = 0;
	private int[] place;

	public int totalNQueens(int n) {
		place = new int[n];
		nQueens(0, n);
		return sum;
	}

	private void nQueens(int cur, int n) {
		if (cur == n) {
			sum++;
		} else {
			for (int i = 0; i <= n - 1; i++) {
				place[cur] = i;
				if (isValid(cur, n)) {
					nQueens(cur + 1, n);
				}
			}
		}
	}

	private boolean isValid(int cur, int n) {
		for (int i = 0; i <= cur - 1; i++) {
			if (place[cur] == place[i]
					|| Math.abs(place[cur] - place[i]) == cur - i) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueensII_52 test = new NQueensII_52();
		int res = test.totalNQueens(3);
		System.out.println(res);
	}

}
