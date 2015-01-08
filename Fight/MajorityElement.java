package Fight;

class MajorityElement {
	public int majorityElement(int[] num) {
		int majorNum = num[0];
		int majorCount = 1;
		for (int i = 1; i <= num.length - 1; i++) {
			if (majorNum == num[i]) {
				majorCount++;
			} else {
				majorCount--;
			}
			if (majorCount == 0) {
				majorNum = num[i];
				majorCount = 1;
			}
		}
		return majorNum;
	}
}
