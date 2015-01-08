package Fight;

public class SingleNumber {
	public int singleNumber(int[] A) {
		int ans = A[0];
		for (int i = 1; i <= A.length - 1; i++) {
			ans = ans ^ A[i];
		}
		return ans;
	}
}
