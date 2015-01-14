package Fight;

public class RemoveDuplicatesfromSortedListII_82 {
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return head;
		}

		ListNode tmp = new ListNode(-1);
		tmp.next = null;

		ListNode tmpTail = tmp;
		ListNode preNode = head;
		ListNode nextNode = head.next;
		int preVal = preNode.val;

		int count = 1;

		while (nextNode != null) {
			if (nextNode.val == preVal) {
				nextNode = nextNode.next;
				count++;
			} else {
				if (count == 1) {
					tmpTail.next = preNode;
					tmpTail = preNode;
					preNode.next = null;
				}
				preNode = nextNode;
				nextNode = nextNode.next;
				preVal = preNode.val;
				count = 1;
			}
		}

		if (count == 1) {
			tmpTail.next = preNode;
			preNode.next = null;
		}

		return tmp.next;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedListII_82 test = new RemoveDuplicatesfromSortedListII_82();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		a.next = b;
		b.next = c;
		c.next = null;

		ListNode head = test.deleteDuplicates(a);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

}
