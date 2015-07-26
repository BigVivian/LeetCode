package Fight;

/**
 * LeetCode - 106 / Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * 根据中序和后续遍历的结果还原二叉树
 * 
 * @author Vivian
 * 
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode root = build(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
		return root;
	}

	public TreeNode build(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {

		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIndex = findIndex(inorder, inStart, postorder[postEnd]);

		// 注意下标区间
		root.left = build(inorder, inStart, inIndex - 1, postorder, postStart,
				postStart + inIndex - inStart - 1);
		root.right = build(inorder, inIndex + 1, inEnd, postorder, postStart
				+ inIndex - inStart, postEnd - 1);

		return root;
	}

	private int findIndex(int[] inorder, int inStart, int val) {
		for (int i = inStart; i <= inorder.length - 1; i++) {
			if (inorder[i] == val) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 3, 6 };
		int[] postorder = { 4, 5, 2, 6, 3, 1 };
		ConstructBinaryTreefromInorderandPostorderTraversal_106 test = new ConstructBinaryTreefromInorderandPostorderTraversal_106();
		TreeNode root = test.buildTree(inorder, postorder);

		System.out.println(root.val);

	}

}
