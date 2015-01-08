package Fight;

import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		pushLeftChild(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (!stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tmp = stack.pop();
		int val = tmp.val;
		pushLeftChild(tmp.right);
		return val;
	}

	private void pushLeftChild(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
