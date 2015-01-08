package Fight;

public class SortColors_75 {
	// O(2*n)
	public void sortColors(int[] A) {
		int[] count = { 0, 0, 0 };
		for (int num : A) {
			switch (num) {
			case 0:
				count[0]++;
				break;
			case 1:
				count[1]++;
				break;
			case 2:
				count[2]++;
				break;
			default:
				break;
			}
		}
		for (int i = 0; i <= count[0] + count[1] + count[2] - 1; i++) {
			if (i <= count[0] - 1) {
				A[i] = 0;
			} else if (i > count[0] - 1 && i <= count[0] + count[1] - 1) {
				A[i] = 1;
			} else {
				A[i] = 2;
			}

		}
	}

	// O(n)
	public void sortColors2(int[] A) {
		int len = A.length;

		int red = 0;
		int white = len - 1;
		int blue = len - 1;

		while (red <= white) {
			if (A[red] == 2) {
				int tmp = A[blue];
				A[red] = tmp;
				A[blue] = 2;
				blue--;
				if (blue < white) {
					white = blue;
				}

			} else if (A[red] == 1) {
				int tmp = A[white];
				A[red] = tmp;
				A[white] = 1;
				white--;
			} else {
				red++;
			}
		}

	}

	public static void main(String[] args) {

	}

}
