package Fight;

// 重点复习，第一次写的时候花了很长的时间
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;

		ListNode root = new ListNode(Integer.MIN_VALUE);
		root.next = null;

		ListNode currentNode = head;
		while (currentNode != null) {
			ListNode nextNode = currentNode.next;

			ListNode pre = root;
			ListNode cur = root.next;
			while (cur != null && cur.val <= currentNode.val) {
				pre = cur;
				cur = cur.next;
			}
			// find and insert
			currentNode.next = cur;
			pre.next = currentNode;

			currentNode = nextNode;
		}

		return root.next;
	}

	public static void main(String[] args) {
		InsertionSortList test = new InsertionSortList();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		a.next = b;
		test.insertionSortList(a);
	}
}
