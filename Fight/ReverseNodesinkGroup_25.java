package Fight;

/**
 * 针对链表，K个一组，对链表进行逆序，小于K个组不逆序
 * 
 * @author Vivian
 * 
 */
public class ReverseNodesinkGroup_25 {

	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode pre = dummy;

		while (hasKNodes(pre.next, k)) {
			pre = reverseKNodes(pre, pre.next, k);
		}

		return dummy.next;
	}

	// 检测是否有K个元素
	public boolean hasKNodes(ListNode head, int k) {

		if (head == null) {
			return false;
		}

		int count = 1;
		while (head != null && count < k) {
			head = head.next;
			count++;
		}
		if (head != null && count == k) {
			return true;
		} else {
			return false;
		}
	}

	// 将K个元素逆序
	public ListNode reverseKNodes(ListNode preHead, ListNode head, int k) {

		ListNode last = head;
		ListNode cur = head.next;

		int count = 1;
		while (cur != null && count != k) {
			ListNode next = cur.next;
			ListNode tmp = preHead.next;
			preHead.next = cur;
			cur.next = tmp;
			last.next = next;

			// go on
			cur = next;
			count++;
		}

		return last;
	}

	public static void main(String[] args) {

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);

		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		ReverseNodesinkGroup_25 test = new ReverseNodesinkGroup_25();
		ListNode res = test.reverseKGroup(one, 3);

		System.out.println("88888");
	}
}
