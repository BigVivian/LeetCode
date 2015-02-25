package Fight;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int n) {

        if (n == 0 || head == null) {
            return head;
        }

        // count the list length
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        int left = count - ((n <= count) ? n : n % count);
        if (left <= 0 || left == count) {
            return head;
        }

        ListNode pre = head;
        ListNode next = head.next;
        left--;
        while (left > 0) {
            pre = pre.next;
            next = next.next;
            left--;
        }

        ListNode newHead = next;
        pre.next = null;

        ListNode insert = newHead;
        while (insert.next != null) {
            insert = insert.next;
        }
        insert.next = head;

        return newHead;

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

        RotateList_61 test = new RotateList_61();
        printList(n1);
        ListNode head = test.rotateRight(n1, 5);
        printList(head);
    }
}
