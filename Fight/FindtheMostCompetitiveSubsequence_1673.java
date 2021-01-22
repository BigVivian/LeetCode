package Fight;

import java.util.Stack;

public class FindtheMostCompetitiveSubsequence_1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++) {
            while(!stack.empty() && nums[i] < stack.peek() && stack.size() -1 + nums.length - i >= k) {
                stack.pop();
            }

            if(stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
