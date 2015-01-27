package Fight;

/**
 * Convert sorted Array to Binary Search Tree<br>
 * 
 * @author Vivian
 * 
 */
public class ConvertSortedArraytoBinarySearchTree_108 {
	public TreeNode sortedArrayToBST(int[] num) {

		TreeNode head = createTree(0, num.length - 1, num);
		return head;
	}

	public TreeNode createTree(int left, int right, int[] num) {

		if (left > right) {
			return null;
		}
		int middle = (left + right) / 2;

		TreeNode leftNode = createTree(left, middle - 1, num);
		TreeNode rightNode = createTree(middle + 1, right, num);

		TreeNode midNode = new TreeNode(num[middle]);
		midNode.left = leftNode;
		midNode.right = rightNode;

		return midNode;
	}

	public static void main(String[] args) {

	}

}
