package Fight;

/**
 * 删除链表中，值为val的结点
 * 
 * @author Vivian
 * 
 */
public class RemoveLinkedListElements_203 {
	public ListNode removeElements(ListNode head, int val) {

		ListNode tmpHead = new ListNode(-1);
		tmpHead.next = head;

		ListNode before = tmpHead;
		ListNode current = head;

		while (current != null) {
			ListNode next = current.next;

			if (current.val == val) {
				before.next = next;
				current = next;
			} else {
				before = current;
				current = next;
			}
		}

		return tmpHead.next;
	}

	public static void main(String[] args) {

	}

}
