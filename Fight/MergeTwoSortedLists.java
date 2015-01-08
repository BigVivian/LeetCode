package Fight;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode sorted = new ListNode(Integer.MIN_VALUE);
		sorted.next = null;

		ListNode current = sorted;

		ListNode pre1 = l1;
		ListNode pre2 = l2;

		while (pre1 != null || pre2 != null) {
			ListNode next1 = (pre1 == null) ? null : pre1.next;
			ListNode next2 = (pre2 == null) ? null : pre2.next;

			if (pre1 == null) {
				current.next = pre2;
				break;
			} else if (pre2 == null) {
				current.next = pre1;
				break;
			} else {
				if (pre1.val <= pre2.val) {
					current.next = pre1;
					pre1.next = null;
					current = pre1; // change the sorted current
					pre1 = next1; // continue l1
				} else {
					current.next = pre2;
					pre2.next = null;
					current = pre2;
					pre2 = next2;
				}
			}
		}

		return sorted.next;
	}

	public static void main(String[] args) {

	}

}
