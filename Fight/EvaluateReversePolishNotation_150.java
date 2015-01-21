package Fight;

import java.util.Stack;

/**
 * use stack to fulfill
 * 
 * @author Vivian
 * 
 */
public class EvaluateReversePolishNotation_150 {
	public int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i <= tokens.length - 1; i++) {
			int num1;
			int num2;
			if (tokens[i].equals("+")) {
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 + num2);
			} else if (tokens[i].equals("-")) {
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 - num2);
			} else if (tokens[i].equals("*")) {
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 * num2);
			} else if (tokens[i].equals("/")) {
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 / num2);
			} else {
				stack.push(Integer.valueOf(tokens[i]));
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		EvaluateReversePolishNotation_150 test = new EvaluateReversePolishNotation_150();
		int res = test.evalRPN(tokens);
		System.out.println(res);
	}

}
