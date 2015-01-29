package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination - BackTracking<br>
 * 
 * @author Vivian
 * 
 */
public class Combinations_77 {
	List<List<Integer>> res;
	int[] subCombine;

	public List<List<Integer>> combine(int n, int k) {
		res = new ArrayList<List<Integer>>();
		subCombine = new int[k];

		combineKFromN(0, k, 1, n);

		return res;
	}

	private void combineKFromN(int cur, int k, int start, int n) {
		if (cur == k) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (int subInt : subCombine) {
				tmp.add(subInt);
			}
			res.add(tmp);
		} else {
			for (int i = start; i <= n; i++) {
				subCombine[cur] = i;
				combineKFromN(cur + 1, k, i + 1, n);
			}
		}
	}

	public static void main(String[] args) {
		Combinations_77 test = new Combinations_77();

		List<List<Integer>> res = test.combine(4, 3);

		for (int i = 0; i <= res.size() - 1; i++) {
			List<Integer> tmp = res.get(i);
			System.out.print("[ ");
			for (Integer a : tmp) {
				System.out.print(a + " ");
			}
			System.out.print("]\n");
		}

	}
}
