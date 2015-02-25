package Fight;

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {

        ListNode left = null;
        ListNode lLast = null;
        ListNode right = null;
        ListNode rLast = null;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                if (left == null) {
                    left = current;
                    current = current.next;
                    left.next = null;
                    lLast = left;
                } else {
                    lLast.next = current;
                    current = current.next;
                    lLast.next.next = null;
                    lLast = lLast.next;
                }

            } else {
                if (right == null) {
                    right = current;
                    current = current.next;
                    right.next = null;
                    rLast = right;
                } else {
                    rLast.next = current;
                    current = current.next;
                    rLast.next.next = null;
                    rLast = rLast.next;
                }
            }

        }

        if (left != null) {
            lLast.next = right;
        } else {
            left = right;
        }


        return left;
    }
}
