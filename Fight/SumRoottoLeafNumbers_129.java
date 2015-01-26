package Fight;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree - Layer Traversal<br>
 * change val of the child node
 * 
 * @author Vivian
 * 
 */
public class SumRoottoLeafNumbers_129 {
	public int sumNumbers(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int sum = 0;

		if (root != null) {
			queue.offer(root);
		} else {
			return 0;
		}

		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if (tmp.left != null) {
				tmp.left.val = tmp.val * 10 + tmp.left.val;
				queue.offer(tmp.left);
			}
			if (tmp.right != null) {
				tmp.right.val = tmp.val * 10 + tmp.right.val;
				queue.offer(tmp.right);
			}
			if (tmp.left == null && tmp.right == null) {
				sum += tmp.val;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
	}

}
