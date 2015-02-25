package Fight;

/**
 * 2(a+b) = a+b+c+b, then a = c (a: from head to Y; b:from Y to Z; c: from Z to Y)
 * fast and slow meet at a node Z
 * from node Z and node head, will meet at node Y where the cycle begins
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }
}
