package Fight;

/**
 * 判断一颗二叉树是否为对称的二叉树
 * 
 * 使用递归进行判断
 * 
 * @author Vivian
 * 
 */
public class SymmetricTree_101 {
	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;

		return symmetricTree(root.left, root.right);
	}

	private boolean symmetricTree(TreeNode root1, TreeNode root2) {
		if (root1 == null)
			return root2 == null;

		if (root2 == null)
			return root1 == null;

		if (root1.val == root2.val) {
			return symmetricTree(root1.right, root2.left)
					&& symmetricTree(root1.left, root2.right);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		SymmetricTree_101 test = new SymmetricTree_101();
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = null;
		boolean res = test.isSymmetric(root);
		System.out.println(res);
	}
}