package Fight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题目看错了....

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {

		int min;
		int total = 0;
		for (int i = 0; i <= triangle.size() - 1; i++) {
			min = triangle.get(i).get(0);
			for (int j = 1; j <= triangle.get(i).size() - 1; j++) {
				min = triangle.get(i).get(j) < min ? triangle.get(i).get(j)
						: min;
			}
			total += min;
		}

		return total;
	}

	public int minimumTotal2(List<List<Integer>> triangle) {

		int[] min = new int[triangle.size()];

		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j <= triangle.get(i).size() - 1; j++) {
				if (i == triangle.size() - 1) {
					min[j] = triangle.get(i).get(j);
				} else {
					min[j] = triangle.get(i).get(j)
							+ Math.min(min[j], min[j + 1]);
				}
			}
		}

		return min[0];
	}

	public static void main(String[] args) {
		Triangle test = new Triangle();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(-1));
		triangle.add(Arrays.asList(2, 3));
		triangle.add(Arrays.asList(1, -1, -3));

		int res = test.minimumTotal2(triangle);
		System.out.println(res);
	}
}
