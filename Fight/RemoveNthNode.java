package Fight;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		List<ListNode> list = new ArrayList<ListNode>();

		ListNode temp = head;
		while (temp != null) {
			list.add(temp);
			temp = temp.next;
		}

		if (n == list.size()) {
			return head.next;
		} else if (n == 1) {
			list.get(list.size() - 1).next = null;
		} else {
			list.get(list.size() - n - 1).next = list.get(list.size() - n + 1);
		}

		return head;
	}
}
