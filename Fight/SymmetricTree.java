package Fight;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int layerCount = 1;

		StringBuffer layer = new StringBuffer();
		while (!queue.isEmpty()) {

			for (int i = 0; i <= layerCount - 1; i++) {
				TreeNode tmpNode = queue.poll();
				if (tmpNode != null) {
					queue.offer(tmpNode.left);
					queue.offer(tmpNode.right);
					layer.append(String.valueOf(tmpNode.val));
				} else {
					layer.append("#");
				}
			}
			if (!isSymmetricStr(layer)) {
				return false;
			} else {
				layer = new StringBuffer();
			}

			layerCount = layerCount * 2;
		}

		if (layer.length() != 0 && layer.length() != layerCount) {
			return false;
		}

		return true;
	}

	private boolean isSymmetricStr(StringBuffer sb) {
		if (sb.length() == 1) {
			return true;
		} else {
			int len = sb.length();
			for (int i = 0; i <= len / 2 - 1; i++) {
				if (sb.charAt(i) != sb.charAt(len - 1 - i)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SymmetricTree test = new SymmetricTree();
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = null;
		boolean res = test.isSymmetric(root);
		System.out.println(res);
	}
}