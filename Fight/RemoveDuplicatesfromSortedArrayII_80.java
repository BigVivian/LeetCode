package Fight;

/**
 * 数组中的元素最多出现两次，返回值为删除元素后的数组大小<br>
 * A = [1,1,1,2,2,3] -> A = [1,1,2,2,3], return 5
 * 
 * @author Vivian
 * 
 */
public class RemoveDuplicatesfromSortedArrayII_80 {

	public int removeDuplicates(int[] A) {

		if (A.length <= 0) {
			return 0;
		}

		int count = A.length;

		int numCount = 1; // previous number count
		int preNum = A[0]; // previous number
		int insertPos = 1; // 保存可插入的index

		for (int i = 1; i <= A.length - 1; i++) {

			if (A[i] == preNum) {
				numCount++;
				if (numCount <= 2) {
					A[insertPos] = A[i];
					insertPos++;
				} else {
					count--;
				}
			} else {
				// 读入新的数
				preNum = A[i];
				numCount = 1;
				A[insertPos] = A[i];
				insertPos++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 1, 1, 3, 3 };
		RemoveDuplicatesfromSortedArrayII_80 test = new RemoveDuplicatesfromSortedArrayII_80();
		int length = test.removeDuplicates(A);

		System.out.println(length);
	}

}
