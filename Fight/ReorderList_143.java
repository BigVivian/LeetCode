package Fight;

/**
 * 1.find the middle of a linked list
 * 2.reverse the second list
 * 3.merge two list
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {

        if (head != null) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // find the middle of the LinkedList（Use slow & fast）
            ListNode second = slow.next;
            slow.next = null;

            // reverse second List
            second = reverseList(second);

            // insert
            ListNode p1 = head;
            ListNode p2 = second;
            while (p2 != null) {
                ListNode tmp1 = p1.next;
                ListNode tmp2 = p2.next;

                p1.next = p2;
                p2.next = tmp1;

                p1 = tmp1;
                p2 = tmp2;
            }
        }

    }

    private ListNode reverseList(ListNode head) {

        ListNode newHead = new ListNode(-1);
        newHead.next = null;

        while (head != null) {
            ListNode tmp = newHead.next;
            ListNode next = head.next;

            newHead.next = head;
            head.next = tmp;

            head = next;
        }

        return newHead.next;
    }

    public static void printList(ListNode n) {
        System.out.println("------");
        while (n != null) {
            System.out.print(n.val);
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ReorderList_143 test = new ReorderList_143();

        printList(n1);

        test.reorderList(n1);

        printList(n1);
    }
}
