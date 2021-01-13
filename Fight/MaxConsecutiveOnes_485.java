package Fight;

public class MaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) cur++;
            else {
                max = cur > max ? cur : max;
                cur = 0;
            }
        }
        max = cur > max ? cur : max;
        return max;
    }
}
