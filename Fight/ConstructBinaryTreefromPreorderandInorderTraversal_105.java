package Fight;

/**
 * LeetCode -105 / Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * 根据先序和中序的结果还原二叉树
 * 
 * @author Vivian
 * 
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
		return root;
	}

	public TreeNode build(int[] preorder, int preStart, int preEnd,
			int[] inorder, int inStart, int inEnd) {

		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = findNode(inorder, inStart, preorder[preStart]);

		// 注意下标区间
		root.left = build(preorder, preStart + 1, preStart + inIndex - inStart,
				inorder, inStart, inIndex - 1);
		root.right = build(preorder, preStart + inIndex - inStart + 1, preEnd,
				inorder, inIndex + 1, inEnd);

		return root;
	}

	public int findNode(int[] inorder, int inStart, int val) {

		for (int i = inStart; i <= inorder.length - 1; i++) {
			if (inorder[i] == val) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 5, 3, 6 };
		int[] inorder = { 4, 2, 5, 1, 3, 6 };
		ConstructBinaryTreefromPreorderandInorderTraversal_105 test = new ConstructBinaryTreefromPreorderandInorderTraversal_105();
		TreeNode root = test.buildTree(preorder, inorder);

		System.out.println("****" + root.val);
	}
}
