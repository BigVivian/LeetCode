package Fight;

import java.util.Arrays;

public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N-k];
    }

}
