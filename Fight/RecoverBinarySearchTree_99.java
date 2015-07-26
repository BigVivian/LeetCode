package Fight;

/**
 * LeetCode 99 / Recover Binary Search Tree / 恢复二叉搜索树
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * @author Vivian
 * 
 */
public class RecoverBinarySearchTree_99 {
	TreeNode p = null, q = null, pre = null;

	public void recoverTree(TreeNode root) {
		inOrder(root);
		int tmp = q.val;
		q.val = p.val;
		p.val = tmp;
	}

	/**
	 * 按照中序遍历遍历BST,要交换的节点分别保存在p和q中
	 * 
	 * @param root
	 */
	public void inOrder(TreeNode root) {
		if (root.left != null) {
			inOrder(root.left);
		}

		if (pre != null && pre.val > root.val) {
			if (p == null) {
				p = pre;
			}
			q = root;
		}

		pre = root;

		if (root.right != null) {
			inOrder(root.right);
		}
	}

}
