package Fight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists_23 {
	/**
	 * 效率太低，重复运算过多
	 */
	public ListNode mergeKLists(List<ListNode> lists) {

		if (lists.size() <= 0) {
			return null;
		}

		ListNode headA = null;

		int i;
		for (i = 0; i <= lists.size() - 1; i++) {
			if (lists.get(i) != null) {
				headA = lists.get(i);
				break;
			}
		}

		ListNode preA = null;
		ListNode curA = headA;
		ListNode tmpB = null;

		for (int j = i + 1; j <= lists.size() - 1; j++) {
			ListNode curB = lists.get(j);
			if (curB == null) {
				continue;
			}

			// B中的当前元素插入A中
			while (curB != null && curA != null) {
				int valA = curA.val;
				int valB = curB.val;

				while (curA != null && curA.val < valB) {
					preA = curA;
					curA = curA.next;
				}

				// 将当前元素加在A的头部
				if (preA == null) {
					tmpB = curB.next;
					curB.next = curA;
					headA = curB;

					// 指针后移
					preA = headA;
					curA = headA.next;
				} else {
					// 将当前元素插入A链表的中间
					if (curA != null) {
						tmpB = curB.next;
						preA.next = curB;
						curB.next = curA;
					}

					// 将所有剩下的B链接到A的尾部
					if (curA == null) {
						preA.next = curB;
						continue;
					}
				}

				curB = tmpB;
			}

			// 将A的指针重置
			preA = null;
			curA = headA;
		}

		return headA;
	}

	/**
	 * 解法二：两两合并
	 * 
	 */
	public ListNode mergeKLists2(List<ListNode> lists) {
		if (lists.size() <= 0) {
			return null;
		}
		return merge(lists, 0, lists.size() - 1);
	}

	// divide and conquer
	// [1,2,3,4] -> [1,2],[3,4] -> [1+2] + [3+4]
	public ListNode merge(List<ListNode> lists, int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			return mergeTwoList(merge(lists, start, mid),
					merge(lists, mid + 1, end));
		}

		return lists.get(start);
	}

	// 转化成两个链表的合并
	public ListNode mergeTwoList(ListNode headA, ListNode headB) {

		if (headA == null)
			return headB;
		if (headB == null)
			return headA;

		ListNode dummy = new ListNode(-1);
		dummy.next = headA;

		ListNode cur = dummy;

		while (headA != null && headB != null) {
			if (headA.val < headB.val) {
				headA = headA.next;
			} else {
				ListNode next = headB.next;
				cur.next = headB;
				headB.next = headA;

				headB = next;
			}
			cur = cur.next;
		}

		if (headB != null) {
			cur.next = headB;
		}

		return dummy.next;
	}

	// 使用堆
	public ListNode mergeKLists3(List<ListNode> lists) {

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}

				});

		for (int i = 0; i <= lists.size() - 1; i++) {
			ListNode node = lists.get(i);
			if (node != null) {
				heap.offer(node);
			}
		}

		ListNode head = null;
		ListNode pre = null;
		while (heap.size() > 0) {
			ListNode tmp = heap.poll();

			if (head == null) {
				head = tmp;
				pre = tmp;
			} else {
				pre.next = tmp;
				pre = tmp;
			}

			if (tmp.next != null)
				heap.offer(tmp.next);
		}

		return head;
	}

	public static void main(String[] args) {

		List<ListNode> lists = new ArrayList<ListNode>();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;

		ListNode b1 = new ListNode(0);
		ListNode b2 = new ListNode(2);
		b1.next = b2;

		lists.add(a1);
		lists.add(b1);

		MergekSortedLists_23 test = new MergekSortedLists_23();
		ListNode res = test.mergeKLists3(lists);
		System.out.println("******");
	}
}
