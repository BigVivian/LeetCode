package Fight;

import java.util.Stack;

/**
 * 中序遍历BST,根据BST的特性，元素大小呈递增趋势
 * 
 * @author Vivian
 * 
 */
public class ValidateBinarySearchTree_98 {
	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Integer pre = null;

		while (root != null || !stack.isEmpty()) {
			// push所有左子树
			while (root != null) {
				stack.add(root);
				root = root.left;
			}

			if (!stack.isEmpty()) {
				root = stack.pop();

				// 判断是否为递增序列
				if (pre == null) {
					pre = root.val;
				} else {
					if (root.val > pre) {
						pre = root.val;
					} else {
						return false;
					}
				}

				// 遍历右子树
				root = root.right;
			}
		}

		return true;
	}

	public static void main(String[] args) {

	}

}
