package Fight;

import java.util.HashSet;

/**
 * 1.HashSet
 * 2.Two pointers if two lists has intersection, they will intersect at last few nodes.
 */
public class IntersectionofTwoLinkedLists_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode interNode = null;

        ListNode tmpA = headA;

        HashSet<ListNode> set = new HashSet<ListNode>();
        while (tmpA != null) {
            set.add(tmpA);
            tmpA = tmpA.next;
        }

        ListNode tmpB = headB;
        while (tmpB != null) {
            if (set.contains(tmpB)) {
                interNode = tmpB;
                break;
            } else {
                tmpB = tmpB.next;
            }
        }

        return interNode;
    }

    // Two pointers
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;

        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != null) {
            lenA++;
            tmpA = tmpA.next;
        }
        while (tmpB != null) {
            lenB++;
            tmpB = tmpB.next;
        }

        tmpA = headA;
        tmpB = headB;

        int gap = Math.abs(lenB - lenA);

        if (lenA < lenB) {
            while (gap != 0) {
                tmpB = tmpB.next;
                gap--;
            }
        } else {
            while (gap != 0) {
                tmpA = tmpA.next;
                gap--;
            }
        }

        while (tmpA != tmpB) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }

        return tmpA;
    }
}
