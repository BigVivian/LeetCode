package Fight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (root == null) {
			return list;
		}

		Stack<Integer> evenStack = new Stack<Integer>(); // 偶数层放入stack
		List<Integer> oddList = new ArrayList<Integer>(); // 奇数层放入tmpList
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);
		int curLevel = 1, nextLevel = 0;
		boolean isOdd = true;

		while (!queue.isEmpty()) {

			TreeNode curNode = queue.poll();
			if (isOdd) {
				oddList.add(curNode.val);
			} else {
				evenStack.push(curNode.val);
			}

			if (curNode.left != null) {
				queue.offer(curNode.left);
				nextLevel++;
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
				nextLevel++;
			}

			curLevel--;
			// 本层元素遍历完成
			if (curLevel == 0) {
				curLevel = nextLevel;
				nextLevel = 0;

				if (isOdd) {
					list.add(oddList);
					oddList = new ArrayList<Integer>();
					isOdd = false;
				} else {
					while (!evenStack.isEmpty()) {
						oddList.add(evenStack.pop());
					}
					list.add(oddList);
					evenStack = new Stack<Integer>();
					oddList = new ArrayList<Integer>();
					isOdd = true;
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		one.left = two;
		one.right = three;
		three.left = four;
		three.right = five;

		BinaryTreeZigzagLevelOrderTraversal_103 test = new BinaryTreeZigzagLevelOrderTraversal_103();
		List<List<Integer>> res = test.zigzagLevelOrder(one);
		System.out.println("****");
	}

}
