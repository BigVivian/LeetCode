package Fight;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		ListNode head = null;
		ListNode tmpHead = null;
		boolean carry = false;

		while (tmp1 != null || tmp2 != null || carry == true) {

			int val1;
			int val2;

			val1 = (tmp1 != null) ? tmp1.val : 0;
			val2 = (tmp2 != null) ? tmp2.val : 0;

			int val = val1 + val2 + (carry == true ? 1 : 0);

			if (val >= 10) {
				val -= 10;
				carry = true;
			} else {
				carry = false;
			}

			if (head == null) {
				head = new ListNode(val);
				tmpHead = head;
			} else {
				tmpHead.next = new ListNode(val);
				tmpHead = tmpHead.next;
			}

			tmp1 = (tmp1 == null) ? null : tmp1.next;
			tmp2 = (tmp2 == null) ? null : tmp2.next;
		}

		return head;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {

	}

}
