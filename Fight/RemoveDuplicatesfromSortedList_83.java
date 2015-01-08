package Fight;

public class RemoveDuplicatesfromSortedList_83 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		pre.next = null;

		while (cur != null) {
			if (pre.val == cur.val) {
				cur = cur.next;
			} else {
				pre.next = cur;
				pre = cur;
				cur = cur.next;
				pre.next = null;
			}
		}

		return head;
	}

	public static void main(String[] args) {

	}

}
