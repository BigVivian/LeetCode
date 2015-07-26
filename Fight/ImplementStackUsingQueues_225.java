package Fight;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode-225 / Implement Stack using queues
 */
public class ImplementStackUsingQueues_225 {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        if (queue2.size() == 0) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.size() != 0) {
            popAToB(queue1, queue2);
        } else {
            popAToB(queue2, queue1);
        }
    }

    private int popAToB(Queue<Integer> A, Queue<Integer> B) {
        while (A.size() > 1) {
            B.offer(A.poll());
        }
        return A.poll();
    }

    // Get the top element.
    public int top() {
        int res;
        if (queue1.size() != 0) {
            res = popAToB(queue1, queue2);
            queue2.offer(res);
        } else {
            res = popAToB(queue2, queue1);
            queue1.offer(res);
        }
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if (queue1.size() == 0 && queue2.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
