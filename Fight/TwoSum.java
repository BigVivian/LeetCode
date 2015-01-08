package Fight;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	// time exceed
	public int[] twoSum(int[] numbers, int target) {
		int[] a = new int[2];
		for (int i = 0; i <= numbers.length - 2; i++) {
			for (int j = i + 1; j <= numbers.length - 1; j++) {
				if (numbers[i] + numbers[j] == target) {
					if (numbers[i] > numbers[j]) {
						a[0] = j;
						a[1] = i;
					} else {
						a[0] = i;
						a[1] = j;
					}
					return a;
				}
			}
		}

		return a;

	}

	// better solution
	public int[] twoSum_1(int[] numbers, int target) {
		int[] a = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i <= numbers.length - 1; i++) {
			if (!map.containsKey(numbers[i])) {
				map.put(target - numbers[i], i);
			} else {
				a[0] = map.get(numbers[i]) + 1;
				a[1] = i + 1;
			}
		}

		return a;

	}

	public static void main(String[] args) {
		TwoSum s = new TwoSum();
		int[] numbers = { 2, 7, 9, 11 };
		int target = 9;
		int a[] = s.twoSum_1(numbers, target);
		System.out.println(a[0]);
	}
}
