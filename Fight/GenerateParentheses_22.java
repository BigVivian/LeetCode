package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定N，求出左右括号可匹配的所有组合<br>
 * 
 * @Solution 递归
 * 
 * @author Vivian
 * 
 */
public class GenerateParentheses_22 {
	List<String> res = new ArrayList<String>();
	String str = "";

	public List<String> generateParenthesis(int n) {
		generate(n, 0, 0, str);
		return res;
	}

	public void generate(int n, int left, int right, String sb) {

		if (right > left) {
			return;
		}

		if (left + right > 2 * n)
			return;

		if (left == n && right == n) {
			res.add(sb.toString());
			return;
		}

		generate(n, left + 1, right, sb + "(");
		generate(n, left, right + 1, sb + ")");
	}

	public static void main(String[] args) {
		GenerateParentheses_22 test = new GenerateParentheses_22();
		List<String> res = test.generateParenthesis(3);

		for (String tmp : res) {
			System.out.println(tmp);
		}
	}
}
