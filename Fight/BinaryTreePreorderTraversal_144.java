package Fight;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历的三种方法<br>
 * 1.递归实现方法<br>
 * 2.使用栈辅助，有两种实现方法<br>
 * 
 * @author Vivian
 * 
 */
public class BinaryTreePreorderTraversal_144 {
	List<Integer> list = new ArrayList<Integer>();

	// recursive
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root != null) {
			list.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		return list;
	}

	// iterate
	public List<Integer> preorderTraversal2(TreeNode root) {
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				list.add(root.val);
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}

		return list;
	}

	// iteration 2
	public List<Integer> preorderTraversal3(TreeNode root) {

		if (root == null) {
			return list;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if (tmp != null) {
				list.add(tmp.val);
				stack.add(tmp.right);
				stack.add(tmp.left);
			}
		}

		return list;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
        int count = 0;
    for(int i =2; i<= 1400; i++){
        if (1400%i == 0){
                   count++;
        }
    }
        System.out.print(count);
	}

}
