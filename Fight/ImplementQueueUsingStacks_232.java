package Fight;

import java.util.Stack;

/**
 * LeetCode 232 - Implement Queue Using Stacks / 使用栈实现队列
 * 
 * @author Vivian
 * 
 */
public class ImplementQueueUsingStacks_232 {

	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		stack1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (stack2.size() != 0) {
			stack2.pop();
		} else {
			this.moveFrom1To2();
			stack2.pop();
		}
	}

	// Get the front element.
	public int peek() {
		if (stack2.size() != 0) {
			return stack2.peek();
		} else {
			this.moveFrom1To2();
			return stack2.peek();
		}
	}

	// Return whether the queue is empty.
	public boolean empty() {
		if (stack1.size() == 0 && stack2.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void moveFrom1To2() {
		while (!stack1.isEmpty()) {
			int val = stack1.peek();
			stack1.pop();
			stack2.push(val);
		}
	}

}
