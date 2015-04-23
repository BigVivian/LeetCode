package Fight;

/**
 * 
 * 求树中是否有从根节点到叶子节点的路径，使得路径上的和为sum
 * 
 * DFS,递归求解
 * 
 * 
 * @author Vivian
 * 
 */
public class PathSum_112 {
	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) {
			return false;
		}

		return pathSum(root, sum, 0);
	}

	private boolean pathSum(TreeNode root, int sum, int curSum) {

		if (root == null) {
			return false;
		}

		// 仅当root为叶子节点时，比较是否相等
		if (root.left == null && root.right == null) {
			return curSum + root.val == sum;
		}

		return pathSum(root.left, sum, curSum + root.val)
				|| pathSum(root.right, sum, curSum + root.val);
	}
}
