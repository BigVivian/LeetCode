package Fight;

/**
 * LeetCode -222 / Count Complete Tree Nodes
 * 
 * 计算一个完全二叉树中的节点个数
 * 
 * 完全二叉树：除最后一层外，每一层上的节点数均达到最大值；在最后一层上只缺少右边的若干结点。
 * 
 * Definition of Complete Binary Tree
 * 
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level h.
 * 
 * @author Vivian
 * 
 */
public class CountCompleteTreeNodes_222 {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = 1;
		int rightHeight = 1;

		TreeNode tmp = root.left;
		while (tmp != null) {
			leftHeight++;
			tmp = tmp.left;
		}

		tmp = root.right;
		while (tmp != null) {
			rightHeight++;
			tmp = tmp.right;
		}

		// 左右子树的高度相等，满二叉树，2^n-1个节点
		if (leftHeight == rightHeight) {
			return (1 << leftHeight) - 1;
		}

		return countNodes(root.left) + countNodes(root.right) + 1;
	}
}
