package Fight;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Postorder Traversal of Binary Tree<br>
 * 
 * 1.recursive<br>
 * 2.iteration & stack<br>
 * 
 * @author Vivian
 * 
 */
public class BinaryTreePostorderTraversal_145 {

	List<Integer> list = new ArrayList<Integer>();

	// recursive
	public List<Integer> postorderTraversal(TreeNode root) {
		traversal(root);
		return list;
	}

	private void traversal(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				traversal(root.left);
			}
			if (root.right != null) {
				traversal(root.right);
			}
			list.add(root.val);
		}
	}

	// iteration
	public List<Integer> postorderTraversal1(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.push(root);
		} else {
			return list;
		}

		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			list.add(0, tmp.val);

			if (tmp.left != null) {
				stack.push(tmp.left);
			}
			if (tmp.right != null) {
				stack.push(tmp.right);
			}
		}

		return list;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
