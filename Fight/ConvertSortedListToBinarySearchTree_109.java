package Fight;

/**
 * LeetCode - 109 / Convert Sorted List to Binary Search Tree / 将排序的链表转换为二叉搜索树
 * 
 * @author Vivian
 * 
 */
public class ConvertSortedListToBinarySearchTree_109 {

	public TreeNode sortedListToBST(ListNode head) {

		int len = getLen(head);
		TreeNode root = build(head, 0, len - 1);

		return root;
	}

	public TreeNode build(ListNode head, int start, int end) {
		if (start > end) {
			return null;
		}
		int middle = (start + end) / 2;

		ListNode tmp = head;
		for (int i = start; i < middle; i++) {
			tmp = tmp.next;
		}

		TreeNode left = build(head, start, middle - 1);
		TreeNode right = build(tmp.next, middle + 1, end);

		TreeNode root = new TreeNode(tmp.val);

		root.left = left;
		root.right = right;

		return root;
	}

	private int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}

		return len;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		head.next = two;
		two.next = three;

		ConvertSortedListToBinarySearchTree_109 test = new ConvertSortedListToBinarySearchTree_109();
		TreeNode root = test.sortedListToBST(head);

		System.out.println("*****");
	}
}
