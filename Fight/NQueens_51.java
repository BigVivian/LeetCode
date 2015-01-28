package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * N-Queens<br>
 * BackTracking
 * 
 * @author Vivian
 * 
 */
public class NQueens_51 {

	List<String[]> res;
	int[] place;

	public List<String[]> solveNQueens(int n) {
		res = new ArrayList<String[]>();
		place = new int[n];

		nQueens(0, n);

		return res;
	}

	private void nQueens(int cur, int n) {
		if (cur == n) {
			shapeRes();
		} else {
			for (int i = 0; i <= n - 1; i++) {
				place[cur] = i;
				if (isValid(cur)) {
					nQueens(cur + 1, n);
				}
			}

		}
	}

	private void shapeRes() {
		int len = place.length;
		String[] tmp = new String[len];

		for (int i = 0; i <= len - 1; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j <= len - 1; j++) {
				if (j != place[i]) {
					sb.append(".");
				} else {
					sb.append("Q");
				}
			}
			tmp[i] = sb.toString();
		}
		res.add(tmp);
	}

	private boolean isValid(int cur) {
		for (int i = 0; i <= cur - 1; i++) {
			if (place[i] == place[cur]
					|| Math.abs(place[i] - place[cur]) == cur - i) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens_51 test = new NQueens_51();
		List<String[]> res = test.solveNQueens(4);

		for (String[] tmp : res) {
			for (int i = 0; i <= tmp.length - 1; i++) {
				System.out.println(tmp[i]);
			}
			System.out.println("******");
		}
	}
}
