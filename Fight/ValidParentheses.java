package Fight;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i <= s.length() - 1; i++) {

			switch (s.charAt(i)) {
			case '(':
				stack.push(1);
				break;
			case ')':
				if (!stack.isEmpty() && stack.peek().equals(1)) {
					stack.pop();
				} else {
					stack.push(-1);
				}
				break;
			case '{':
				stack.push(2);
				break;
			case '}':
				if (!stack.isEmpty() && stack.peek().equals(2)) {
					stack.pop();
				} else {
					stack.push(-2);
				}
				break;
			case '[':

				stack.push(3);
				break;
			case ']':
				if (!stack.isEmpty() && stack.peek().equals(3)) {
					stack.pop();
				} else {
					stack.push(-3);
				}
				break;
			default:
				break;
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		ValidParentheses s = new ValidParentheses();
		boolean is = s.isValid("{}]");
		System.out.println(is);
	}
}
