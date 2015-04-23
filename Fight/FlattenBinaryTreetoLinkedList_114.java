package Fight;

import java.util.Stack;

/**
 * 将一个二叉树转换为一个只包含右子树的flatten tree,元素顺序按照先序遍历的顺序
 * 
 * @author Vivian
 * 
 */
public class FlattenBinaryTreetoLinkedList_114 {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		// 按照先序遍历方法重新构造树
		TreeNode lastNode = null;
		while (!stack.isEmpty()) {
			TreeNode curNode = stack.pop();
			if (lastNode == null) {
				lastNode = curNode;
			} else {
				lastNode.left = null;
				lastNode.right = curNode;
				lastNode = curNode;
			}

			// 注意栈的顺序先进后出
			if (curNode.right != null) {
				stack.push(curNode.right);

			}
			if (curNode.left != null) {
				stack.push(curNode.left);
			}
		}

	}

	public static void main(String[] args) {

	}

}
