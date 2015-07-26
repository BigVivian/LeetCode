package Fight;

/**
 * LeetCode-237 / delete the ListNode / [the given node is the node to be deleted]
 */
public class DeleteNodeInALinkedList_237 {

    public void deleteNode(ListNode node) {
        ListNode pre = node;

        // copy the value
        while (node.next != null) {
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode next = new ListNode(1);
        node.next = next;

        DeleteNodeInALinkedList_237 test = new DeleteNodeInALinkedList_237();
        test.deleteNode(node);

        System.out.print("....");
    }
}
