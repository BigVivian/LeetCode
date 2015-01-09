package Fight;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();

	public void push(int x) {
		stack.push(x);

		if (min.isEmpty()) {
			min.push(x);
		} else {
			if (x < min.peek()) {
				min.push(x);
			} else {
				min.push(min.peek());
			}
		}

	}

	public void pop() {
		if (!stack.isEmpty()) {
			stack.pop();
			min.pop();
		}
	}

	public int top() {
		if (!stack.isEmpty()) {
			return stack.peek();
		} else {
			return -1;
		}
	}

	public int getMin() {
		return min.peek();
	}
}
