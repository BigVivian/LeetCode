package Fight;

/**
 * 链表，每两个结点交换顺序，画图便于理解
 * 
 * pre -> A -> B -> next <br>
 * pre -> B -> A -> next <br>
 * 
 * @author Vivian
 * 
 */
public class SwapNodesinPairs_24 {
	public ListNode swapPairs(ListNode head) {

		ListNode pre = new ListNode(-1);
		pre.next = head;

		ListNode next = null;

		ListNode tmpHead = pre;

		// 存在一个pair
		while (pre != null && pre.next != null && pre.next.next != null) {
			ListNode A = pre.next;
			ListNode B = A.next;
			next = B.next;

			// swap
			pre.next = B;
			B.next = A;
			A.next = next;

			// go on
			pre = A;
		}

		return tmpHead.next;
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);

		one.next = two;
		two.next = three;
		three.next = four;

		SwapNodesinPairs_24 test = new SwapNodesinPairs_24();
		ListNode res = test.swapPairs(one);
	}
}
