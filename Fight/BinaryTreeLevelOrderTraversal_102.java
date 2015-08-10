package Fight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Level order traversal<br>
 * 
 * 1.record the current layer num. <br>
 * 2.use the queue.<br>
 * 
 * @author Vivian
 * 
 */
public class BinaryTreeLevelOrderTraversal_102 {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> layerList = new ArrayList<List<Integer>>();
		Queue<Object[]> queue = new LinkedList<Object[]>();
		Object[] objects = new Object[2];
		int layer = 0;
		int currentLayer = 0;
		List<Integer> currentLayerList = new ArrayList<Integer>();
		TreeNode node = null;

		// offer the root
		if (root == null) {
			return layerList;
		} else {
			objects[0] = layer;
			objects[1] = root;
			queue.offer(objects);
		}

		while (!queue.isEmpty()) {

			// 1.poll the first
			objects = queue.poll();
			//layer = (int)（objects[0]）;
			node = (TreeNode) objects[1];

			if (currentLayer == layer) {
				currentLayerList.add(node.val);
			} else {
				layerList.add(currentLayerList);
				currentLayerList = new ArrayList<Integer>();
				currentLayer++;
				currentLayerList.add(node.val);
			}

			// 2.add the left node and right node
			layer++;
			if (node.left != null) {
				objects = new Object[2];
				objects[0] = layer;
				objects[1] = node.left;
				queue.offer(objects);
			}
			if (node.right != null) {
				objects = new Object[2];
				objects[0] = layer;
				objects[1] = node.right;
				queue.offer(objects);
			}
		}
		if (!currentLayerList.isEmpty()) {
			layerList.add(currentLayerList);
		}

		return layerList;
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);

		one.left = two;
		one.right = three;

		two.left = null;
		two.right = null;

		three.left = null;
		three.right = null;

		BinaryTreeLevelOrderTraversal_102 test = new BinaryTreeLevelOrderTraversal_102();
		List<List<Integer>> list = test.levelOrder(one);

	}

}
