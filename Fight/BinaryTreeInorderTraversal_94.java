package Fight;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> list = new ArrayList<Integer>();

	// recursive
	public List<Integer> inorderTraversal1(TreeNode root) {
		if (root != null) {
			inorderTraversal1(root.left);
			list.add(root.val);
			inorderTraversal1(root.right);
		}
		return list;
	}

	// iteration 1
	public List<Integer> inorderTraversal2(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				list.add(root.val);// 体现中序
				root = root.right;
			}
		}
		return list;
	}

	// iteration 2
	public List<Integer> inorderTraversal3(TreeNode root) {

		return null;
	}

	public static void main(String[] args) {

	}

}
