package Fight;

/**
 * 反转链表
 */
public class ReverseLinkedList_206 {

    //iteratively
    public ListNode reverseList(ListNode head) {

        ListNode tmpHead = new ListNode(-1);

        while (head != null) {
            ListNode second = tmpHead.next;
            ListNode tmp = head.next;
            tmpHead.next = head;
            head.next = second;

            head = tmp;
        }


        return tmpHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ReverseLinkedList_206 test = new ReverseLinkedList_206();
        test.reverseList(head);
    }
}
