package Fight;

/**
 * Sort List<br>
 * 在O(nlogn)的时间内进行链表的排序<br>
 * 1.归并的思想;2.使用slow和fast找到中间节点;3.排序链表的合并
 * 
 * @author Vivian
 * 
 */
public class SortList_148 {
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode middle = getMiddleNode(head);
		ListNode headB = middle.next;
		middle.next = null;

		return mergeList(sortList(head), sortList(headB));
	}

	// merge two sorted list
	private ListNode mergeList(ListNode headA, ListNode headB) {

		ListNode headC = new ListNode(-1);
		ListNode currentNode = headC;

		while (headA != null && headB != null) {
			if (headA.val <= headB.val) {
				currentNode.next = headA;
				headA = headA.next;
			} else {
				currentNode.next = headB;
				headB = headB.next;
			}

			currentNode = currentNode.next;
		}

		if (headA != null) {
			currentNode.next = headA;
		} else if (headB != null) {
			currentNode.next = headB;
		}

		return headC.next;
	}

	// get middle node of list
	private ListNode getMiddleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fast = head.next.next, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public static void main(String[] args) {

	}

}
