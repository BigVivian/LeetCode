package Fight;

public class SortColors_75 {
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
	}

	public static void main(String[] args) {

	}

}
