package Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode-228 / Summary Ranges
 */
public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();

        if (nums.length <= 0) {
            return res;
        }

        int first = nums[0], last = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            int cur = nums[i];
            if (cur == last + 1) {
                last = cur;
            } else {
                if (first == last) {
                    res.add(String.valueOf(first));
                } else {
                    res.add(first + "->" + last);
                }

                first = cur;
                last = cur;
            }
        }
        if (first == last) {
            res.add(String.valueOf(first));
        } else {
            res.add(first + "->" + last);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 4};
        SummaryRanges_228 test = new SummaryRanges_228();
        List<String> res = test.summaryRanges(nums);

        System.out.println("....");
    }
}
