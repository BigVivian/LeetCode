package Fight;

/**
 * 求一棵树是否为平衡二叉树<br>
 * 1.树 - 深度遍历<br>
 * 2.递归
 * 
 * @author Vivian
 * 
 */
public class BalancedBinaryTree_110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		return getHeight(root) >= 0;

	}

	// Tree - DFS
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
			return -1;
		}

		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);

		one.left = two;
		one.right = three;

		two.left = four;
		two.right = null;

		four.left = five;
		four.right = null;
		five.left = six;
		five.right = null;
		six.left = null;
		six.right = null;

		three.left = null;
		three.right = null;

		BalancedBinaryTree_110 test = new BalancedBinaryTree_110();
		boolean res = test.isBalanced(one);
		System.out.println(res);
	}
}
