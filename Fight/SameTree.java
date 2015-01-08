package Fight;

/**
 * 题目:判断两棵二叉树是否相同 <br>
 * 解法：递归
 * 
 * @author Vivian
 * 
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else {
			return p.val == q.val && isSameTree(p.left, q.left)
					&& isSameTree(p.right, q.right);
		}
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

	}

}
