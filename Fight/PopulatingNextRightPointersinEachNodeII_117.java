package Fight;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populating Next Right Pointers in Each Node II<br>
 * 
 * 连接已知树的每层<br>
 * 方法1: 层序遍历, 空间:O(logN) 时间:O(N)<br>
 * 方法2:扫描父节点时,连接左右节点,空间O(1),时间O(n)<br>
 * 
 * @author Vivian
 * 
 */
public class PopulatingNextRightPointersinEachNodeII_117 {

	// 方法1： 层序遍历, 空间:O(logN) 时间:O(N)
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		int curLevel = 0, nextLevel = 0;

		queue.add(root);
		curLevel = 1;

		TreeLinkNode preNode = null;
		while (!queue.isEmpty()) {
			TreeLinkNode curNode = queue.poll();
			curLevel--;

			if (curNode.left != null) {
				queue.offer(curNode.left);
				nextLevel++;
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
				nextLevel++;
			}

			if (preNode == null) {
				preNode = curNode;
			} else {
				preNode.next = curNode;
				preNode = curNode;
			}

			if (curLevel == 0) {
				curNode.next = null;
				curLevel = nextLevel;
				nextLevel = 0;
				preNode = null;
			}

		}
	}

	// 方法2:扫描父节点时,连接左右节点,空间O(1),时间O(n)
	public void connect2(TreeLinkNode root) {

		while (root != null) {
			TreeLinkNode pre = null; // 每层中的前一个节点
			TreeLinkNode nextRoot = null; // 每层的第一个节点，相当于下一个root

			while (root != null) {
				if (nextRoot == null) {
					nextRoot = root.left != null ? root.left : root.right;
				}

				if (root.left != null) {
					if (pre != null) {
						pre.next = root.left;
					}
					pre = root.left;
				}
				if (root.right != null) {
					if (pre != null) {
						pre.next = root.right;
					}
					pre = root.right;
				}

				root = root.next;
			}
			root = nextRoot;
		}

	}

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			this.val = x;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode two = new TreeLinkNode(2);
		TreeLinkNode three = new TreeLinkNode(3);
		root.left = two;
		root.right = three;

		PopulatingNextRightPointersinEachNodeII_117 test = new PopulatingNextRightPointersinEachNodeII_117();
		test.connect(root);

		System.out.println("*****");
	}

}
