package Fight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BackTracking<br>
 * 
 * @author Vivian
 * 
 */
public class Subsets_78 {
	List<List<Integer>> result;
	int[] select;

	public List<List<Integer>> subsets(int[] S) {
		result = new ArrayList<List<Integer>>();
		select = new int[S.length];

		generate(0, S.length, S);

		return result;
	}

	private void generate(int cur, int n, int[] S) {
		if (cur == n) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (int i = 0; i <= select.length - 1; i++) {
				if (select[i] == 0) {
					tmp.add(S[i]);
					Collections.sort(tmp);
				}
			}
			result.add(tmp);
		} else {
			for (int i = 0; i <= 1; i++) {
				select[cur] = i;
				generate(cur + 1, n, S);
			}
		}
	}

	public static void main(String[] args) {
		Subsets_78 test = new Subsets_78();

		int[] S = { 4, 1, 0 };
		List<List<Integer>> res = test.subsets(S);
	}
}
