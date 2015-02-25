package Fight;

/**
 * if a link list has a cycle, slow and fast will meet at one node
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;


        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
