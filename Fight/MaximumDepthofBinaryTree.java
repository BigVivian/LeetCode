package Fight;

public class MaximumDepthofBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 递归的方法
	 * 
	 * @param root
	 * @return max depth of a binary tree
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = 1;
		int right = 1;
		left += maxDepth(root.left);
		right += maxDepth(root.right);

		return (left > right) ? left : right;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
