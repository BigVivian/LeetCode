package Fight;

/**
 *
 */
public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        // 0 element
        if (head == null) {
            return true;
        }
        // 1 element
        if (head.next == null) {
            return true;
        }

        int count = 1;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }

        ListNode middle = null;
        // even
        if (fast.next == null) {
            middle = slow.next;
        }
        // odd
        else {
            middle = slow.next.next;
        }

        middle = reverse(middle);

        for (int i = 1; i <= count; i++) {
            if(head.val == middle.val){
                head = head.next;
                middle = middle.next;
            }else{
                return false;
            }
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = null;

        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            ListNode tmp = tmpHead.next;
            tmpHead.next = cur;
            cur.next = tmp;

            cur = next;
        }

        return tmpHead.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;
        three.next = null;

        PalindromeLinkedList_234 test = new PalindromeLinkedList_234();
        boolean res = test.isPalindrome(one);

        System.out.println("*****res: " + res);
    }
}
