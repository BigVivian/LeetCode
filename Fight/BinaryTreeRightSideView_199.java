package Fight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的每层的最右的结点<br>
 * 
 * @solution 层序遍历，使用currentCount和nextCount记录当前层和下一层的结点个数
 * 
 * @author Vivian
 * 
 */
public class BinaryTreeRightSideView_199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		int currentCount = 0, nextCount = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.offer(root);
			currentCount = 1;
		}

		while (queue.size() != 0) {
			TreeNode curNode = queue.poll();
			if (curNode.left != null) {
				queue.offer(curNode.left);
				nextCount++;
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
				nextCount++;
			}

			currentCount--;
			if (currentCount == 0) {
				res.add(curNode.val);
				currentCount = nextCount;
				nextCount = 0;
			}
		}

		return res;
	}

	public static void main(String[] args) {

	}

}
