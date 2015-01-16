package Fight;

public class FindMinimuminRotatedSortedArray_153 {
	public int findMin(int[] num) {

		if (num.length == 1) {
			return num[0];
		}
		if (num.length == 2) {
			return Math.min(num[0], num[1]);
		}

		int res = find(num, 0, num.length - 1);

		return res;
	}

	public int find(int[] num, int start, int end) {

		if (end - start <= 1) {
			return Math.min(num[0], Math.min(num[start], num[end]));
		} else {
			int m = (start + end) / 2;
			if (num[m] < num[m - 1] && num[m] < num[m + 1]) {
				return num[m];
			}

			if (num[m] > num[start]) {
				return find(num, m, end);
			} else {
				return find(num, start, m);
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 2, 3, 1 };
		FindMinimuminRotatedSortedArray_153 test = new FindMinimuminRotatedSortedArray_153();
		int min = test.findMin(num);

		System.out.println(min);
	}

}
