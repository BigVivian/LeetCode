package Fight;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode-226 / Invert Binary Tree / 交换二叉树的左右子树
 * 
 * @author Vivian
 * 
 */
public class InvertBinaryTree_226 {
	private Queue<TreeNode> queue = new LinkedList<TreeNode>();

	public TreeNode invertTree(TreeNode root) {
		invert(root);
		return root;
	}

	public void invert(TreeNode root) {
		if (root != null) {
			queue.offer(root);
		}
		while (queue.size() != 0) {
			TreeNode curNode = queue.poll();
			TreeNode tmp = null;

			if (curNode.left != null || curNode.right != null) {
				tmp = curNode.left;
				curNode.left = curNode.right;
				curNode.right = tmp;
			}

			if (curNode.left != null) {
				queue.offer(curNode.left);
			}

			if (curNode.right != null) {
				queue.offer(curNode.right);
			}

		}
	}

}
