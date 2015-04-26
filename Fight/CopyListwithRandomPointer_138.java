package Fight;

/**
 * 复制链表<br>
 * 
 * 1.若复制1->2->3->4<br>
 * 2.1->1->2->2->3->3->4->4<br>
 * 3.拆分复制的链表
 * 
 * @author Vivian
 * 
 */
public class CopyListwithRandomPointer_138 {
	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null) {
			return null;
		}

		RandomListNode currentNode = head;

		// 复制list中的next节点
		while (currentNode != null) {
			RandomListNode copyNode = new RandomListNode(currentNode.label);
			RandomListNode nextNode = currentNode.next;
			currentNode.next = copyNode;
			copyNode.next = nextNode;

			currentNode = currentNode.next.next;
		}

		// 复制list中的random节点
		currentNode = head;
		while (currentNode != null) {
			if (currentNode.random != null) {
				currentNode.next.random = currentNode.random.next;
			}

			currentNode = currentNode.next.next;
		}

		// 将复制的链表和原链表分开
		RandomListNode oldHead = head;
		RandomListNode newHead = head.next;
		RandomListNode newCur = head.next;

		while (oldHead != null) {

			oldHead.next = newCur.next;

			if (oldHead.next != null)
				newCur.next = oldHead.next.next;
			else
				newCur.next = null;

			oldHead = oldHead.next;
			newCur = newCur.next;
		}

		return newHead;
	}

	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		CopyListwithRandomPointer_138 test = new CopyListwithRandomPointer_138();
		RandomListNode newHead = test.copyRandomList(head);

		System.out.println("****");
	}
}
