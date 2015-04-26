package Fight;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII_113 {

	List<List<Integer>> list = new ArrayList<List<Integer>>();
	Stack<Integer> stack = new Stack<Integer>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		if (root == null) {
			return list;
		}

		sum(root, sum, 0);

		return list;
	}

	private void sum(TreeNode root, int sum, int curSum) {

		stack.push(root.val);

		if (root.left == null && root.right == null) {
			if (curSum + root.val == sum) {
				list.add(new ArrayList<Integer>(stack));
			}
		}

		if (root.left != null) {
			sum(root.left, sum, curSum + root.val);
		}
		if (root.right != null) {
			sum(root.right, sum, curSum + root.val);
		}

		// 叶子节点，弹出当前节点
		stack.pop();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(1);

		root.left = left;
		root.right = right;

		PathSumII_113 test = new PathSumII_113();
		List<List<Integer>> res = test.pathSum(root, 1);

		System.out.println("****");
	}

}
